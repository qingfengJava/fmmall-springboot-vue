package com.qingfeng.api.service.feign.fallback;

import com.qingfeng.api.service.feign.OrderAddClient;
import com.qingfeng.fm.beans.Orders;
import com.qingfeng.fm.beans.ShoppingCartVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/22
 */
@Component
public class OrderAddClientFallback implements OrderAddClient {

    @Override
    public List<ShoppingCartVO> saveOrder(Orders order, String cids) {
        System.out.println("order-add--------服务降级");
        return null;
    }
}
