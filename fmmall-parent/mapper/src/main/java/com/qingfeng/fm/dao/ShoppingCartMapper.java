package com.qingfeng.fm.dao;

import com.qingfeng.fm.entity.ShoppingCart;
import com.qingfeng.fm.entity.ShoppingCartVO;
import com.qingfeng.fm.generaldao.GeneralDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 清风学Java
 */
@Repository
public interface ShoppingCartMapper extends GeneralDao<ShoppingCart> {

    /**
     * 根据用户Id查询用户对应的购物车信息
     * @param userId
     * @return
     */
    public List<ShoppingCartVO> selectShopCartByUserId(int userId);

    /**
     * 根据购物车Id修改购物车商品数量
     * @param cartId
     * @param cartNum
     * @return
     */
    public int updateCartNumByCartId(@Param("cartId") int cartId,
                                     @Param("cartNum") int cartNum);

    /**
     * 根据购物车Id删除购物车信息
     * @param cartId
     * @return
     */
    public int deleteByCartId(@Param("cartId") int cartId);
}