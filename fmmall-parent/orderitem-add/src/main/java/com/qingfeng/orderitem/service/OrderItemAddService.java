package com.qingfeng.orderitem.service;

import com.qingfeng.fm.entity.ShoppingCartVO;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/21
 */
public interface OrderItemAddService {

    /**
     * 保存商品快照
     * @param list
     * @param orderId
     * @return
     */
    public int save(List<ShoppingCartVO> list, String orderId);
}
