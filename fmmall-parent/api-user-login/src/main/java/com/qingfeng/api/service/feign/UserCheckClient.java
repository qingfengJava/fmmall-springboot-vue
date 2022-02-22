package com.qingfeng.api.service.feign;

import com.qingfeng.api.service.feign.fallback.UserCheckClientFallback;
import com.qingfeng.fm.beans.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/14
 */
@FeignClient(value = "user-check",fallback = UserCheckClientFallback.class)
public interface UserCheckClient {

    /**
     * 调用user-check服务的check方法
     * @param username
     * @return
     */
    @GetMapping("user/check")
    public Users check(@RequestParam("username") String username);
}
