package com.qingfeng.order.service.feigin;

import com.qingfeng.fm.beans.ProductSku;
import com.qingfeng.order.service.feigin.fallback.StockUpdateClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/24
 */
@FeignClient(value = "stock-update",fallback = StockUpdateClientFallback.class)
public interface StockUpdateClient {

    /**
     * 更新
     * @param skus
     * @return
     */
    @PutMapping("/stock/update")
    public int update(List<ProductSku> skus);
}
