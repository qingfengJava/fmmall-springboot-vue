package com.qingfeng.api.service;

import com.qingfeng.fm.beans.Orders;

import java.util.Map;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/22
 */
public interface OrderSubmitService {

    /**
     * 添加订单接口
     * @param cids
     * @param order
     * @return
     */
    public Map<String,String> addOrder(String cids, Orders order);
}
