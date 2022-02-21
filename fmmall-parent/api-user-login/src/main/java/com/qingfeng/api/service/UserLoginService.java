package com.qingfeng.api.service;

import com.qingfeng.fm.vo.ResultVO;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/14
 */
public interface UserLoginService {

    /**
     * 用户登录
     * @param name 用户名
     * @param pwd 密码
     * @return
     */
    public ResultVO checkLogin(String name, String pwd);
}
