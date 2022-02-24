package com.qingfeng.order.service.feigin;

import com.qingfeng.fm.beans.OrderItem;
import com.qingfeng.order.service.feigin.fallback.OrderStatusUpdateClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/24
 */
@FeignClient(value = "orderitem-query",fallback = OrderStatusUpdateClientFallback.class)
public interface OrderItemQueryClient {

    /**
     * orderitem-query服务的查询操作
     * @param orderId
     * @return
     */
    @GetMapping("/orderitem/query")
    public List<OrderItem> query(@RequestParam("orderId") String orderId);
}
