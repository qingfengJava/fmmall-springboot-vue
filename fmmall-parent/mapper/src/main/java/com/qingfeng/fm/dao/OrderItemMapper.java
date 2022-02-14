package com.qingfeng.fm.dao;

import com.qingfeng.fm.entity.OrderItem;
import com.qingfeng.fm.generaldao.GeneralDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 清风学Java
 */
@Repository
public interface OrderItemMapper extends GeneralDao<OrderItem> {

    /**
     * 根据订单查询商品快照
     * @param orderId
     * @return
     */
    public List<OrderItem> listOrderItemsByOrderId(String orderId);
}