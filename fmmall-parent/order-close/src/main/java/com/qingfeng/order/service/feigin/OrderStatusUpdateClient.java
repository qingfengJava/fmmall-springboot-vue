package com.qingfeng.order.service.feigin;

import com.qingfeng.fm.beans.Orders;
import com.qingfeng.order.service.feigin.fallback.OrderStatusUpdateClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/24
 */
@FeignClient(value = "order-status-update",fallback = OrderStatusUpdateClientFallback.class)
public interface OrderStatusUpdateClient {

    /**
     * order-status-update服务的更新
     * @param order
     * @return
     */
    @PutMapping("/order/status/update")
    public int update(@RequestBody Orders order);
}
