package com.qingfeng.api.service.feign.fallback;

import com.qingfeng.api.service.feign.UserCheckClient;
import com.qingfeng.fm.beans.Users;
import org.springframework.stereotype.Component;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/20
 */
@Component
public class UserCheckClientFallback implements UserCheckClient {

    @Override
    public Users check(String username) {
        System.out.println("user-check ~~~~~~~~~~~~服务降级");
        return new Users();
    }
}
