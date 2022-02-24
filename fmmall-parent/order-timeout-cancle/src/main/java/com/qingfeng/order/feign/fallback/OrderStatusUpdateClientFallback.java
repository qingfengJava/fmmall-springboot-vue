package com.qingfeng.order.feign.fallback;

import com.qingfeng.fm.beans.Orders;
import com.qingfeng.order.feign.OrderStatusUpdateClient;
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
        System.out.println("order-status-update  ---------- 降级服务");
        return 0;
    }
}
