package com.qingfeng.user.controller;

import com.qingfeng.fm.entity.Users;
import com.qingfeng.user.service.UserSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/20
 */
@RestController
@RequestMapping("/user")
public class UserSaveController {

    @Autowired
    private UserSaveService userSaveService;

    @PostMapping("/save")
    public int save(@RequestBody Users user){
        return userSaveService.saveUser(user);
    }
}
