package com.qingfeng.api.controller;

import com.qingfeng.api.service.UserLoginService;
import com.qingfeng.fm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 处理用户登录的控制层
 *
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/14
 */
@RestController
@CrossOrigin
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @GetMapping("/user/login")
    public ResultVO login(@RequestParam("username") String name,
                          @RequestParam(value = "password") String pwd){
        ResultVO resultVO = userLoginService.checkLogin(name, pwd);
        return resultVO;
    }
}
