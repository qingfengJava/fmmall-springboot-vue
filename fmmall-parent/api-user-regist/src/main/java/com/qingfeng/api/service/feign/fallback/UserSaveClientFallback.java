package com.qingfeng.api.service.feign.fallback;

import com.qingfeng.api.service.feign.UserSaveClient;
import com.qingfeng.fm.beans.Users;
import org.springframework.stereotype.Component;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/20
 */
@Component
public class UserSaveClientFallback implements UserSaveClient {

    @Override
    public int save(Users user) {
        return 0;
    }
}
