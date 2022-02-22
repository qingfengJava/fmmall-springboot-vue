package com.qingfeng.order.controller;

import com.qingfeng.fm.entity.Orders;
import com.qingfeng.fm.entity.ShoppingCartVO;
import com.qingfeng.order.service.OrderAddService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/22
 */
@RestController
public class OrderAddController {

    private static final Logger log = LoggerFactory.getLogger(OrderAddController.class);
    @Autowired
    private OrderAddService orderAddService;

    @PostMapping("/order/save")
    public List<ShoppingCartVO> saveOrder(@RequestBody Orders order, String cids){
        log.info("方法进来了......-------------order-add");
        return orderAddService.save(order,cids);
    }
}
