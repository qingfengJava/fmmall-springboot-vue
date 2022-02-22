package com.qingfeng.api.service.feign.fallback;

import com.qingfeng.api.service.feign.UserCheckClient;
import com.qingfeng.fm.beans.Users;
import org.springframework.stereotype.Component;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/14
 */
@Component
public class UserCheckClientFallback implements UserCheckClient {

    /**
     * 服务请求失败后的回调方法
     * @param username
     * @return
     */
    @Override
    public Users check(String username) {
        //如果调用user-check服务失败，则返回null
        System.out.println("user-check ~~~~~~~~~~~~服务降级");
        return null;
    }
}
