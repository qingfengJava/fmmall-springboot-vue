package com.qingfeng.api.controller;

import com.qingfeng.api.service.UserRegsitService;
import com.qingfeng.fm.beans.Users;
import com.qingfeng.fm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/20
 */
@RestController
@CrossOrigin
public class UserRegistController {

    @Autowired
    private UserRegsitService userRegsitService;

    /**
     * 注册
     * @param users
     * @return
     */
    @PostMapping("user/regist")
    public ResultVO regist(@RequestBody Users users){
        return userRegsitService.regist(users.getUsername(),users.getPassword());
    }
}
