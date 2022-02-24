package com.qingfeng.order.service;

import com.qingfeng.fm.entity.Orders;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/23
 */
public interface OrderTimeoutQueryService {

    /**
     * 列表清单
     * @return
     */
    public List<Orders> listOrders();
}
