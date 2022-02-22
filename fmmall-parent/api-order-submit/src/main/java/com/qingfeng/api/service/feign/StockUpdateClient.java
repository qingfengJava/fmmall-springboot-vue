package com.qingfeng.api.service.feign;

import com.qingfeng.api.service.feign.fallback.StockUpdateClientFallback;
import com.qingfeng.fm.beans.ProductSku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/22
 */
@FeignClient(value = "stock-update",fallback = StockUpdateClientFallback.class)
public interface StockUpdateClient {

    /**
     * 更新库存
     * @param skus
     * @return
     */
    @PutMapping("/stock/update")
    public int update(List<ProductSku> skus);
}
