package com.qingfeng.api.service.feign;

import com.qingfeng.api.service.feign.fallback.ShopcartDelClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/22
 */
@FeignClient(value = "shopcart-del",fallback = ShopcartDelClientFallback.class)
public interface ShopcartDelClient {

    /**
     * 删除购物车
     * @param cids
     * @return
     */
    @DeleteMapping("/shopcart/del")
    public int delete(@RequestParam("cids") String cids);
}
