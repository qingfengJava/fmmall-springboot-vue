package com.qingfeng.api.service.feign;

import com.qingfeng.api.service.feign.fallback.UserSaveClientFallback;
import com.qingfeng.fm.beans.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/20
 */
@FeignClient(value = "user-save" , fallback = UserSaveClientFallback.class)
public interface UserSaveClient {

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    @PostMapping("user/save")
    public int save(Users user);
}
