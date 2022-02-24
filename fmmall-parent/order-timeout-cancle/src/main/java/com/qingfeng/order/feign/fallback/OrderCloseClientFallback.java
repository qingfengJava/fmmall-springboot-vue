package com.qingfeng.order.feign.fallback;

import com.qingfeng.order.feign.OrderCloseClient;
import org.springframework.stereotype.Component;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/24
 */
@Component
public class OrderCloseClientFallback implements OrderCloseClient {

    @Override
    public int close(String orderId, int closeType) {
        System.out.println("order-close---------------服务降级");
        return 0;
    }
}
