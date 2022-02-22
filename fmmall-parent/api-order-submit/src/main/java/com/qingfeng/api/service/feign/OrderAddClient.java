package com.qingfeng.api.service.feign;

import com.qingfeng.api.service.feign.fallback.OrderAddClientFallback;
import com.qingfeng.fm.beans.Orders;
import com.qingfeng.fm.beans.ShoppingCartVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/22
 */
@FeignClient(value = "order-add",fallback = OrderAddClientFallback.class)
public interface OrderAddClient {

    /**
     * 调用order-add的保存订单的方法
     * @param order
     * @param cids
     * @return
     */
    @PostMapping("/order/save")
    public List<ShoppingCartVO> saveOrder(Orders order,@RequestParam("cids") String cids);
}
