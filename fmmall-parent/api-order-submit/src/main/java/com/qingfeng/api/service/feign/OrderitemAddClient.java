package com.qingfeng.api.service.feign;

import com.qingfeng.api.service.feign.fallback.OrderitemAddClientFallback;
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
@FeignClient(value = "orderitem-add",fallback = OrderitemAddClientFallback.class)
public interface OrderitemAddClient {

    /**
     * 添加商品快照
     * @param list
     * @param orderId
     * @return
     */
    @PostMapping("/item/save")
    public int addOrderItem(List<ShoppingCartVO> list,@RequestParam("orderId") String orderId);

}