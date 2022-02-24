package com.qingfeng.order.feign;

import com.qingfeng.fm.beans.Orders;
import com.qingfeng.order.feign.fallback.OrderTimeoutQueryClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/24
 */
@FeignClient(value = "order-timeout-query",fallback = OrderTimeoutQueryClientFallback.class)
public interface OrderTimeoutQueryClient {

    /**
     * 查询
     * @return
     */
    @GetMapping("/order/query/timeout")
    public List<Orders> query();
}
