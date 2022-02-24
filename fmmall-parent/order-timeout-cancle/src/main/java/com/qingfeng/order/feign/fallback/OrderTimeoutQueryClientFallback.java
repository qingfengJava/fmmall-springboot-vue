package com.qingfeng.order.feign.fallback;

import com.qingfeng.fm.beans.Orders;
import com.qingfeng.order.feign.OrderTimeoutQueryClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/24
 */
@Component
public class OrderTimeoutQueryClientFallback implements OrderTimeoutQueryClient {

    @Override
    public List<Orders> query() {
        System.out.println("order-time-query-----------服务降级");
        return new ArrayList<>();
    }
}
