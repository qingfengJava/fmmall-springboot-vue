package com.qingfeng.product.sku.controller;

import com.qingfeng.fm.entity.ProductSku;
import com.qingfeng.product.sku.service.ProductSkuQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/24
 */
@RestController
public class ProductSkuQueryController {

    @Autowired
    private ProductSkuQueryService productSkuQueryService;

    @GetMapping("/product/sku/query")
    public ProductSku query(String skuId){
        return productSkuQueryService.queryProductSku(skuId);
    }
}
