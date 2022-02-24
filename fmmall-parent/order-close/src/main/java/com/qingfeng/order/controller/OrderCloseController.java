package com.qingfeng.order.controller;

import com.qingfeng.order.service.OrderCloseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/23
 */
@RestController
public class OrderCloseController {

    @Autowired
    private OrderCloseService orderCloseService;

    @GetMapping("/order/close")
    public int close(String orderId,int closeType){
        return orderCloseService.closeOrder(orderId,closeType);
    }
}
