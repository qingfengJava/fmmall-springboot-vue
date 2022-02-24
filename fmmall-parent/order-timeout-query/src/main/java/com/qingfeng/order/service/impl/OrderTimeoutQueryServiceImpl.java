package com.qingfeng.order.service.impl;

import com.qingfeng.fm.entity.Orders;
import com.qingfeng.order.dao.OrdersMapper;
import com.qingfeng.order.service.OrderTimeoutQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/23
 */
@Service
public class OrderTimeoutQueryServiceImpl implements OrderTimeoutQueryService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> listOrders() {
        Example example = new Example(Orders.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", "1");
        Date time = new Date(System.currentTimeMillis() - 30 * 60 * 1000);
        //生成订单的时间比当前时间减去半个小时还小，说明是超时订单
        criteria.andLessThan("createTime", time);
        List<Orders> orders = ordersMapper.selectByExample(example);
        return orders;
    }
}
