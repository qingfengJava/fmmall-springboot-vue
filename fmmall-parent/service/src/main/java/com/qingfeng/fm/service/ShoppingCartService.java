package com.qingfeng.fm.service;

import com.qingfeng.fm.entity.ShoppingCart;
import com.qingfeng.fm.vo.ResultVO;

/**
 * 购物车的业务层接口
 *
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/12/17
 */
public interface ShoppingCartService {

    /**
     * 添加购物车信息
     * @param cart
     * @return
     */
    public ResultVO addShoppingCart(ShoppingCart cart);
}
