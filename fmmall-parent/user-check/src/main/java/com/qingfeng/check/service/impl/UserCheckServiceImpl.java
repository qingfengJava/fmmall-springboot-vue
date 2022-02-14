package com.qingfeng.check.service.impl;

import com.qingfeng.check.dao.UserMapper;
import com.qingfeng.check.service.UserCheckService;
import com.qingfeng.fm.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/14
 */
@Service
public class UserCheckServiceImpl implements UserCheckService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Users queryUser(String username) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        List<Users> users = userMapper.selectByExample(example);
        if (users.size() > 0) {
            return users.get(0);
        }else{
            return null;
        }
    }
}
