package com.qingfeng.stock.service;

import com.qingfeng.fm.entity.ShoppingCartVO;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/21
 */
public interface StockQueryService {

    /**
     * 根据商品Id查询商品信息
     * @param cids
     * @return
     */
    public List<ShoppingCartVO> selectShopCartByCids(String cids);

}
