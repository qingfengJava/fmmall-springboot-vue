package com.qingfeng.fm.controller;

import com.qingfeng.fm.service.UserAddrService;
import com.qingfeng.fm.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户收货地址管理控制层
 *
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/12/22
 */
@RestController
@CrossOrigin
@Api(value="提供收货地址相关接口",tags="收货地址管理")
@RequestMapping("/useraddr")
public class UserAddrController {

    @Autowired
    private UserAddrService userAddrService;

    @ApiOperation("根据用户Id查询用户的收货地址")
    @GetMapping("/list")
    @ApiImplicitParam(dataType = "int",name="userId",value="用户Id",required = true)
    public ResultVO listAddr(Integer userId, @RequestHeader("token") String token){
        ResultVO resultVO = userAddrService.listAddrByUid(userId);
        return resultVO;
    }
}
