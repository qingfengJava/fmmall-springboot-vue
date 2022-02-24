package com.qingfeng.order.controller;

import com.qingfeng.fm.entity.OrderItem;
import com.qingfeng.order.service.OrderItemQueryService;
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
public class OrderItemQueryController {

    @Autowired
    private OrderItemQueryService orderItemQueryService;

    @GetMapping("/orderitem/query")
    public List<OrderItem> query(String orderId){
        return orderItemQueryService.queryOrderItem(orderId);
    }
}
