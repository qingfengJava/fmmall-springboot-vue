package com.qingfeng.order.service;

import com.qingfeng.fm.entity.Orders;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/23
 */
public interface OrderStatusUpdateService {

    /**
     * 更新订单状态
     * @param order
     * @return
     */
    public int updateStatus(Orders order);
}
