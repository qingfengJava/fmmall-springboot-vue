package com.qingfeng.fm.service;

import com.qingfeng.fm.vo.ResultVO;

/**
 * @author 清风学Java
 * @date 2021/11/2
 * @apiNote
 */
public interface UserService {

    /**
     * 用户注册
     * @param name 用户名
     * @param pwd 密码
     * @return
     */
    public ResultVO userResgit(String name,String pwd);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public ResultVO checkLogin(String username, String password);
}
