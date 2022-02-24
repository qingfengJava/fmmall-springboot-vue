package com.qingfeng.order.service.feigin.fallback;

import com.qingfeng.fm.beans.ProductSku;
import com.qingfeng.order.service.feigin.ProductSkuQueryClient;
import org.springframework.stereotype.Component;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/24
 */
@Component
public class ProductSkuQueryClientFallback implements ProductSkuQueryClient {

    @Override
    public ProductSku query(String skuId) {
        System.out.println("product-sku-query --------- 服务降级");
        return null;
    }
}
