package com.qingfeng.stock.dao;

import com.qingfeng.fm.entity.ShoppingCart;
import com.qingfeng.fm.entity.ShoppingCartVO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/21
 */
@Repository
public interface ShopCartMapper extends Mapper<ShoppingCart>, MySqlMapper<ShoppingCart> {

    /**
     * 根据购物车Id查询购物车信息
     * @param list
     * @return
     */
    public List<ShoppingCartVO> selectShopCartByCids(List<Integer> list);
}
