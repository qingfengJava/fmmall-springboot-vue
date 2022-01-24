package com.qingfeng.fm.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingfeng.fm.dao.CategoryMapper;
import com.qingfeng.fm.entity.CategoryVO;
import com.qingfeng.fm.service.CategoryService;
import com.qingfeng.fm.vo.ResStatus;
import com.qingfeng.fm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 列表查询的业务层接口实现
 *
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/11/26
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 查询分类列表（包含三个级别的分类）
     * @return
     */
    @Override
    public ResultVO listCategories() {
        List<CategoryVO> categoryVOS = null;
        try {
            //1、查询redis
            String categories = stringRedisTemplate.boundValueOps("categories").get();
            //2、判断
            if(categories != null){
                //redis中存在数据
                JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class,CategoryVO.class);
                categoryVOS = objectMapper.readValue(categories,javaType);
            }else{
                //redis不存在，查询数据库 调用mapper查询所有的列表信息
                categoryVOS = categoryMapper.selectAllCategories();
                stringRedisTemplate.boundValueOps("categories").set(objectMapper.writeValueAsString(categoryVOS),1, TimeUnit.DAYS);

            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //将信息封装到resultVO中
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", categoryVOS);
        return resultVO;
    }

    /**
     * 查询所有的一级分类，同时查询当前一级分类下销量最高的6个商品
     * @return
     */
    @Override
    public ResultVO listFirstLevelCategories() {
        List<CategoryVO> categoryVOS = categoryMapper.selectFirstLevelCategories();
        //将信息封装到resultVO中
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", categoryVOS);
        return resultVO;
    }
}
