package com.qingfeng.user.service;

import com.qingfeng.fm.entity.Users;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/20
 */
public interface UserSaveService {

    /**
     * 保存用户
     * @param user
     * @return
     */
    public int saveUser(Users user);
}
