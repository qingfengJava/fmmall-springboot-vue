package com.qingfeng.shopcart.service;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/21
 */
public interface ShopCartDelService {

    /**
     * 删除购物车
     * @param cids
     * @return
     */
    public int deleteShopCart(String cids);
}
