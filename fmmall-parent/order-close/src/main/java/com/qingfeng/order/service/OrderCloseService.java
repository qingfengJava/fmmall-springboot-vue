package com.qingfeng.order.service;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/23
 */
public interface OrderCloseService {

    /**
     * 订单超时关闭
     * @param orderId
     * @return
     */
    public int closeOrder(String orderId,int closeType);
}
