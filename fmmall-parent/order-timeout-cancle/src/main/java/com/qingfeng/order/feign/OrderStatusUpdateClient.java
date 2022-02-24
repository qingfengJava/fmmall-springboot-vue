package com.qingfeng.order.feign;

import com.qingfeng.fm.beans.Orders;
import com.qingfeng.order.feign.fallback.OrderStatusUpdateClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/24
 */
@FeignClient(value = "order-status-update",fallback = OrderStatusUpdateClientFallback.class)
public interface OrderStatusUpdateClient {

    /**
     * 修改订单
     * @param order
     * @return
     */
    @PutMapping("/order/status/update")
    public int update(Orders order);
}
