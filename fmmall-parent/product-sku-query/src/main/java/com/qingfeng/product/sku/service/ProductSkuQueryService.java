package com.qingfeng.product.sku.service;

import com.qingfeng.fm.entity.ProductSku;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/24
 */
public interface ProductSkuQueryService {

    /**
     * 查询商品类别
     * @param skuId
     * @return
     */
    public ProductSku queryProductSku(String skuId);
}
