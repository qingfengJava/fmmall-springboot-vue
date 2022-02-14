package com.qingfeng.fm.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingfeng.fm.dao.UsersMapper;
import com.qingfeng.fm.entity.Users;
import com.qingfeng.fm.service.UserService;
import com.qingfeng.fm.utils.MD5Utils;
import com.qingfeng.fm.vo.ResStatus;
import com.qingfeng.fm.vo.ResultVO;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 清风学Java
 * @date 2021/11/2
 * @apiNote
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 用户注册
     * @param name 用户名
     * @param pwd 密码
     * @return
     */
    @Override
    @Transactional
    public ResultVO userResgit(String name, String pwd) {
        synchronized (this) {
            //1、根据用户查询，这个用户是否已经被注册
            Example example = new Example(Users.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("username",name);
            List<Users> users = usersMapper.selectByExample(example);


            //2、如果没有被注册，则进行保存操作
            if (users.size() == 0) {
                //使用MD5加密技术对密码进行加密
                String md5Pwd = MD5Utils.md5(pwd);
                Users user = new Users();
                user.setUsername(name);
                user.setPassword(md5Pwd);
                user.setUserImg("img/default.png");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());
                //插入数据，并且主键回填
                int i = usersMapper.insertUseGeneratedKeys(user);
                if (i > 0) {
                    return new ResultVO(ResStatus.OK, "注册成功！", user);
                } else {
                    return new ResultVO(ResStatus.NO, "注册失败！", null);
                }
            } else {
                return new ResultVO(ResStatus.NO, "用户已经被注册", null);
            }
        }
    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public ResultVO checkLogin(String username, String password) {
        //根据用户名查询用户信息是否存在
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        List<Users> users = usersMapper.selectByExample(example);

        if (users.size() == 0){
            return new ResultVO(ResStatus.NO,"登陆失败，用户名不存在！",null);
        }else {
            String md5Pwd = MD5Utils.md5(password);
            if (md5Pwd.equals(users.get(0).getPassword())){
                //如果登录验证成功，则需要生成令牌token（token就是按照特定规则生成的字符串）
                //String token = Base64Utils.encode(username+123456);
                //使用JWT规则生成token字符串
                JwtBuilder builder = Jwts.builder();

                HashMap<String, Object> map = new HashMap<>();
                map.put("key1","value1");
                map.put("key2","value2");

                String token = builder.setSubject(username) //主题，就是token中携带的数据
                        .setIssuedAt(new Date()) //设置token的生成时间
                        .setId(users.get(0).getUserId() + "") //设置用户id为token id
                        .setClaims(map) //map中可以存放用户的角色权限信息
                        .setExpiration(new Date(System.currentTimeMillis() + 24*60*60*1000)) //设置token的过期时间
                        .signWith(SignatureAlgorithm.HS256, "QIANfeng6666") //设置加密方式和加密密码
                        .compact();

                //当用户登录成功之后，以token为key 将用户信息保存到redis中
                try {
                    String userInfo = objectMapper.writeValueAsString(users.get(0));
                    stringRedisTemplate.boundValueOps(token).set(userInfo,30, TimeUnit.MINUTES);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }

                return new ResultVO(ResStatus.OK,token,users.get(0));
            }else {
                return new ResultVO(ResStatus.NO,"登录失败，密码错误！",null);
            }
        }
    }
}
