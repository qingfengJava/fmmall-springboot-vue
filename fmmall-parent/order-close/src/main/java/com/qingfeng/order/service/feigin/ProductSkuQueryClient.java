package com.qingfeng.order.service.feigin;

import com.qingfeng.fm.beans.ProductSku;
import com.qingfeng.order.service.feigin.fallback.ProductSkuQueryClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/24
 */
@FeignClient(value = "product-sku-query",fallback = ProductSkuQueryClientFallback.class)
public interface ProductSkuQueryClient {

    /**
     * product-sku-query服务的商品查询操作
     * @param skuId
     * @return
     */
    @GetMapping("/product/sku/query")
    public ProductSku query(@RequestParam("skuId") String skuId);
}
