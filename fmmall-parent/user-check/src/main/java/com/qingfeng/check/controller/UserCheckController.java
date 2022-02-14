package com.qingfeng.check.controller;

import com.qingfeng.check.service.UserCheckService;
import com.qingfeng.fm.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/14
 */
@RestController
@RequestMapping("/user")
public class UserCheckController {

    @Autowired
    private UserCheckService userCheckService;

    @GetMapping("/check")
    public Users check(String username){
        return userCheckService.queryUser(username);
    }
}
