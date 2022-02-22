package com.qingfeng.api.service.feign.fallback;

import com.qingfeng.api.service.feign.StockUpdateClient;
import com.qingfeng.fm.beans.ProductSku;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/22
 */
@Component
public class StockUpdateClientFallback implements StockUpdateClient {

    private static final Logger log = LoggerFactory.getLogger(StockUpdateClientFallback.class);

    @Override
    public int update(List<ProductSku> skus) {
        log.info("stock-update~~~~~~~~~~~~~~~~~~~~~服务降级");
        return 0;
    }
}
