package com.qingfeng.order.controller;

import com.qingfeng.fm.entity.Orders;
import com.qingfeng.order.service.OrderStatusUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 修改订单状态服务实现
 *
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/23
 */
@RestController
public class OrderStatusUpdateController {

    @Autowired
    private OrderStatusUpdateService orderStatusUpdateService;

    @PutMapping("/order/status/update")
    public int update(@RequestBody Orders order){
        return orderStatusUpdateService.updateStatus(order);
    }
}
