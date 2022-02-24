package com.qingfeng.order.service.impl;

import com.qingfeng.fm.entity.Orders;
import com.qingfeng.order.dao.OrdersMapper;
import com.qingfeng.order.service.OrderStatusUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/23
 */
@Service
public class OrderStatusUpdateServiceImpl implements OrderStatusUpdateService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public int updateStatus(Orders order) {
        int i = ordersMapper.updateByPrimaryKeySelective(order);
        return i;
    }
}
