package com.qingfeng.stock.service;

import com.qingfeng.fm.entity.ProductSku;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/21
 */
public interface StockUpdateService {

    /**
     * 修改库存
     * @param skus
     * @return
     */
    public int updateStock(List<ProductSku> skus);
}
