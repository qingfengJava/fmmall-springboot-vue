package com.qingfeng.order.service.impl;

import com.qingfeng.fm.entity.OrderItem;
import com.qingfeng.order.dao.OrderItemMapper;
import com.qingfeng.order.service.OrderItemQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/23
 */
@Service
public class OrderItemQueryServiceImpl implements OrderItemQueryService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public List<OrderItem> queryOrderItem(String orderId) {
        Example example1 = new Example(OrderItem.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("orderId", orderId);
        List<OrderItem> orderItems = orderItemMapper.selectByExample(example1);
        return orderItems;
    }
}
