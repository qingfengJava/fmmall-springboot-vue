package com.qingfeng.order.service.feigin.fallback;

import com.qingfeng.fm.beans.Orders;
import com.qingfeng.order.service.feigin.OrderStatusUpdateClient;
import org.springframework.stereotype.Component;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/24
 */
@Component
public class OrderStatusUpdateClientFallback implements OrderStatusUpdateClient {

    @Override
    public int update(Orders order) {
        return 0;
    }
}
