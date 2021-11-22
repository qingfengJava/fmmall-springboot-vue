package com.qingfeng.fm.controller;

import com.qingfeng.fm.utils.Base64Utils;
import com.qingfeng.fm.vo.ResStatus;
import com.qingfeng.fm.vo.ResultVO;
import io.jsonwebtoken.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 购物车控制层
 *
 * @author 清风学Java
 * @date 2021/11/19
 * @apiNote
 */
@RestController
@RequestMapping("/shopcart")
@CrossOrigin
@Api(value = "提供购物车业务相关的接口", tags = "购物车管理")
public class ShopCartController {

    @GetMapping("/list")
    @ApiImplicitParam(dataType = "string", name = "token", value = "授权令牌", required = true)
    public ResultVO listCarts(String token) {
        //token校验成功
        return new ResultVO(ResStatus.OK, "success", null);
    }
}
