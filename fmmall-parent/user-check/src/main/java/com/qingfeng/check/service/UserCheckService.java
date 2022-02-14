package com.qingfeng.check.service;

import com.qingfeng.fm.entity.Users;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/14
 */
public interface UserCheckService {


    /**
     * 用户登录
     * @param username 用户名
     * @return
     */
    public Users queryUser(String username);
}
