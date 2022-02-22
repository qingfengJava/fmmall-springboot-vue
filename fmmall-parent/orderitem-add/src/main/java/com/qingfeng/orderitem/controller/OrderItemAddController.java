package com.qingfeng.orderitem.controller;

import com.qingfeng.fm.entity.ShoppingCartVO;
import com.qingfeng.orderitem.service.OrderItemAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 保存订单快照
 *
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/21
 */
@RestController
public class OrderItemAddController {

    @Autowired
    private OrderItemAddService orderItemAddService;

    @PostMapping("/item/save")
    public int addOrderItem(@RequestBody List<ShoppingCartVO> list, String orderId){
        return orderItemAddService.save(list,orderId);
    }
}
