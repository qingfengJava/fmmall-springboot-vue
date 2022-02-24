package com.qingfeng.order.service.feigin.fallback;

import com.qingfeng.fm.beans.ProductSku;
import com.qingfeng.order.service.feigin.StockUpdateClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/24
 */
@Component
public class StockUpdateClientFallback implements StockUpdateClient {

    @Override
    public int update(List<ProductSku> skus) {
        System.out.println("stock-update----------服务降级");
        return 0;
    }
}
