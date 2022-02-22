package com.qingfeng.api.service.feign.fallback;

import com.qingfeng.api.service.feign.ShopcartDelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/22
 */
@Component
public class ShopcartDelClientFallback implements ShopcartDelClient {

    private static final Logger log = LoggerFactory.getLogger(ShopcartDelClientFallback.class);

    @Override
    public int delete(String cids) {
        log.info("shopcart-del--------------服务降级");
        return 0;
    }
}
