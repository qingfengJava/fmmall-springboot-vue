package com.qingfeng.fm.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingfeng.fm.dao.IndexImgMapper;
import com.qingfeng.fm.entity.IndexImg;
import com.qingfeng.fm.service.IndexImgService;
import com.qingfeng.fm.vo.ResStatus;
import com.qingfeng.fm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 轮播图业务的实现
 *
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/11/23
 */
@Service
public class IndexImgServiceImpl implements IndexImgService {

    @Autowired
    private IndexImgMapper indexImgMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 查询轮播图信息
     * @return
     */
    @Override
    public ResultVO listIndexImgs() {
        List<IndexImg> indexImgs = null;
        try {
            //string结构缓存轮播图信息
            String imgsStr = stringRedisTemplate.opsForValue().get("indexImgs");

            //假设1000个请求查询到redis中的数据都是null
            if (imgsStr != null){
                //从redis中获取到了轮播图信息
                JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class,IndexImg.class);
                indexImgs = objectMapper.readValue(imgsStr,javaType);

            }else{
                //双重检查锁解决redis缓存击穿问题
                // 1000个请求都会进入else (service类在spring容器中是单列的，1000个并发会启动1000个线程来处理，但是公用一个service实例)
                synchronized (this){
                    //第二次查询redis
                    String indexImgsStr = stringRedisTemplate.opsForValue().get("indexImgs");
                        //这1000个请求中，只有第一个请求再次查询redis时依然为null
                        if (indexImgsStr == null){

                        //从redis中没有获取到轮播图信息，则查询数据库
                        //调用持久层，查询轮播图信息
                        indexImgs = indexImgMapper.listIndexImgs();

                        //解决缓存穿透
                        if (indexImgs != null){
                            //写入redis
                            stringRedisTemplate.opsForValue().set("indexImgs",objectMapper.writeValueAsString(indexImgs));
                            //设置过期时间为1天
                            stringRedisTemplate.expire("indexImgs",1, TimeUnit.DAYS);
                        }else{
                            //查询数据库也为空，存一个空
                            List<IndexImg> arr = new ArrayList<>();
                            //写入redis
                            stringRedisTemplate.opsForValue().set("indexImgs",objectMapper.writeValueAsString(arr));
                            //设置过期时间为1天
                            stringRedisTemplate.expire("indexImgs",10, TimeUnit.SECONDS);
                        }

                    }else{
                        //从redis中获取到了轮播图信息
                        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class,IndexImg.class);
                        indexImgs = objectMapper.readValue(indexImgsStr,javaType);
                    }
                }
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //容错检查 返回数据
        if (indexImgs == null) {
            return new ResultVO(ResStatus.NO,"fail",null);
        }else {
            return new ResultVO(ResStatus.OK,"success",indexImgs);
        }
    }
}
