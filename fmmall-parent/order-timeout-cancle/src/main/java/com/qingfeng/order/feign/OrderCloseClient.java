package com.qingfeng.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/24
 */
@FeignClient("order-close")
public interface OrderCloseClient {

    /**
     * 关闭订单
     * @param orderId
     * @param closeType
     * @return
     */
    @GetMapping("/order/close")
    public int close(@RequestParam("orderId") String orderId,
                     @RequestParam("closeType") int closeType);
}
