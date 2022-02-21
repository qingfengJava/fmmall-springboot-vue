package com.qingfeng.user.service.impl;

import com.qingfeng.fm.entity.Users;
import com.qingfeng.user.dao.UserMapper;
import com.qingfeng.user.service.UserSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/20
 */
@Service
public class UserSaveServiceImpl implements UserSaveService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(Users user) {
        int i = userMapper.insertUseGeneratedKeys(user);
        return i;
    }
}
