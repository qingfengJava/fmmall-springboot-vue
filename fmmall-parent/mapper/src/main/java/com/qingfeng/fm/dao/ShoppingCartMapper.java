package com.qingfeng.fm.dao;

import com.qingfeng.fm.entity.ShoppingCart;
import com.qingfeng.fm.entity.ShoppingCartVO;
import com.qingfeng.fm.generaldao.GeneralDao;
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
}