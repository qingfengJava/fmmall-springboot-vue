package com.qingfeng.order.service;

import com.qingfeng.fm.entity.OrderItem;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/23
 */
public interface OrderItemQueryService {

    /**
     * 查询订单
     * @param orderId
     * @return
     */
    public List<OrderItem> queryOrderItem(String orderId);
}
