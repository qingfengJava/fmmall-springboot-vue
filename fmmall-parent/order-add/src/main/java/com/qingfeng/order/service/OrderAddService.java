package com.qingfeng.order.service;

import com.qingfeng.fm.entity.Orders;
import com.qingfeng.fm.entity.ShoppingCartVO;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/22
 */
public interface OrderAddService {

    /**
     * 保存订单
     * @param order
     * @param cids
     * @return
     */
    public List<ShoppingCartVO> save(Orders order, String cids);
}
