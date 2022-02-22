package com.qingfeng.shopcart.controller;

import com.qingfeng.shopcart.service.ShopCartDelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/21
 */
@RestController
public class ShopCartDelController {

    @Autowired
    private ShopCartDelService shopCartDelService;

    @DeleteMapping("/shopcart/del")
    public int delete(String cids){
        return shopCartDelService.deleteShopCart(cids);
    }
}
