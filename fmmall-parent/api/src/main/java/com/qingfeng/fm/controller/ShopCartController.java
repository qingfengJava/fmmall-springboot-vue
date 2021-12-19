package com.qingfeng.fm.controller;

import com.qingfeng.fm.entity.ShoppingCart;
import com.qingfeng.fm.service.ShoppingCartService;
import com.qingfeng.fm.vo.ResultVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/add")
    public ResultVO addShoppingCart(@RequestBody ShoppingCart cart,
                                    @RequestHeader("token") String token){
        ResultVO resultVO = shoppingCartService.addShoppingCart(cart);
        return resultVO;
    }
}
