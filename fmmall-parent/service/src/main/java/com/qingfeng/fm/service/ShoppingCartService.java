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

    /**
     * 根据用户Id查询用户对应的购物车的信息
     * @param userId
     * @return
     */
    public ResultVO listShoppingCartByUserId(int userId);

    /**
     * 根据购物车Id修改购物车商品数量
     * @param cartId 购物车Id
     * @param cartNum 要修改的商品数量
     * @return
     */
    public ResultVO updateCartNum(int cartId,int cartNum);

    /**
     * 根据购物车Id删除购物车信息
     * @param cartId
     * @return
     */
    public ResultVO deleteByCartId(int cartId);

    /**
     * 根据购物车Id查询对应的购物车信息
     * @param cids
     * @return
     */
    public ResultVO listShoppingCartsByCids(String cids);
}
