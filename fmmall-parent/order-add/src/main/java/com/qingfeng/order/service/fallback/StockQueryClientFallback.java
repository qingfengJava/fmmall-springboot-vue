package com.qingfeng.order.service.fallback;

import com.qingfeng.fm.entity.ShoppingCartVO;
import com.qingfeng.order.service.feign.StockQueryClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/22
 */
@Component
public class StockQueryClientFallback implements StockQueryClient {

    @Override
    public List<ShoppingCartVO> query(String cids) {
        System.out.println("stock-query---------服务降级");
        return null;
    }
}
