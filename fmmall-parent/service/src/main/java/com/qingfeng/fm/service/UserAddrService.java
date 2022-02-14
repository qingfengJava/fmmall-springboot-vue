package com.qingfeng.fm.service;

import com.qingfeng.fm.vo.ResultVO;

/**
 * 用户收货地址信息业务层接口
 *
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/12/22
 */
public interface UserAddrService {

    /**
     * 根据用户Id查询用户的购买地址
     * @param userId
     * @return
     */
    public ResultVO listAddrByUid(int userId);
}
