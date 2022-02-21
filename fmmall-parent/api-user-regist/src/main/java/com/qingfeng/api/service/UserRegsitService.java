package com.qingfeng.api.service;

import com.qingfeng.fm.vo.ResultVO;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/20
 */
public interface UserRegsitService {

    /**
     * 用户注册
     * @param name
     * @param pwd
     * @return
     */
    public ResultVO regist(String name,String pwd);
}
