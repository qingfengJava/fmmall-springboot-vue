package com.qingfeng.order.service.feigin.fallback;

import com.qingfeng.fm.beans.OrderItem;
import com.qingfeng.order.service.feigin.OrderItemQueryClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/24
 */
@Component
public class OrderItemQueryClientFallback implements OrderItemQueryClient {

    @Override
    public List<OrderItem> query(String orderId) {
        System.out.println("orderitem-query--------服务降级");
        return null;
    }
}
