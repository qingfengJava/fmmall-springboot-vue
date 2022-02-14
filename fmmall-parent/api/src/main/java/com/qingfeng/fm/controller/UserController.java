package com.qingfeng.fm.controller;

import com.qingfeng.fm.beans.Users;
import com.qingfeng.fm.service.UserService;
import com.qingfeng.fm.vo.ResStatus;
import com.qingfeng.fm.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @CrossOrigin 设置可以允许跨域请求，因为是前后端分离的，所以需要跨域请求。
 *
 * @author 清风学Java
 * @date 2021/11/2
 * @apiNote
 */
@RestController
@RequestMapping("/user")
@Api(value = "提供用户的登录和注册接口",tags = "用户管理")
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;

    //url     http://ip:port/fmmall/user/login
    //params  参数类型   参数个数    参数含义
    //method  GET
    //响应数据说明
    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "string",name = "username",value = "用户登录账号",required = true),
            @ApiImplicitParam(paramType = "string",name = "password",value = "用户登录密码",required = true)
    })
    @GetMapping("/login")
    public ResultVO login(@RequestParam(value = "username") String name,
                          @RequestParam(value = "password") String password){
        ResultVO resultVO = userService.checkLogin(name, password);
        return resultVO;
    }

    @ApiOperation("用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "string",name = "username",value = "用户注册账号",required = true),
            @ApiImplicitParam(paramType = "string",name = "password",value = "用户注册密码",required = true)
    })
    @PostMapping("/regist")
    public ResultVO regist(@RequestBody Users user){
        ResultVO resultVO = userService.userResgit(user.getUsername(),user.getPassword());
        return resultVO;
    }

    @ApiOperation("校验token是否过期接口")
    @GetMapping("/check")
    public ResultVO userTokenCheck(@RequestHeader("token")String token){
        return new ResultVO(ResStatus.OK,"success",null);
    }
}
