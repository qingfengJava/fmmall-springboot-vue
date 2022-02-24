package com.qingfeng.product.sku.service.impl;

import com.qingfeng.fm.entity.ProductSku;
import com.qingfeng.product.sku.dao.ProductSkuMapper;
import com.qingfeng.product.sku.service.ProductSkuQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/24
 */
@Service
public class ProductSkuQueryServiceImpl implements ProductSkuQueryService {

    @Autowired
    private ProductSkuMapper productSkuMapper;

    @Override
    public ProductSku queryProductSku(String skuId) {
        return productSkuMapper.selectByPrimaryKey(skuId);
    }
}
