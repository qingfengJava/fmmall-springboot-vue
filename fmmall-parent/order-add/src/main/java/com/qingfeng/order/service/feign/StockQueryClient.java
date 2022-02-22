package com.qingfeng.order.service.feign;

import com.qingfeng.fm.entity.ShoppingCartVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/22
 */
@FeignClient("stock-query")
public interface StockQueryClient {

    /**
     * 调用stock-query服务的方法
     * @param cids
     * @return
     */
    @GetMapping("stock/query")
    public List<ShoppingCartVO> query(@RequestParam("cids") String cids);
}
