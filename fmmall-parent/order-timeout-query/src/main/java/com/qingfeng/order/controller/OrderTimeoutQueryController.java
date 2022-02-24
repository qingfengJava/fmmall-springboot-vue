package com.qingfeng.order.controller;

import com.qingfeng.fm.entity.Orders;
import com.qingfeng.order.service.OrderTimeoutQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/23
 */
@RestController
public class OrderTimeoutQueryController {

    @Autowired
    private OrderTimeoutQueryService orderTimeoutQueryService;

    @GetMapping("/order/query/timeout")
    public List<Orders> query(){
        //查询并返回超时未支付的订单
        return orderTimeoutQueryService.listOrders();
    }
}
