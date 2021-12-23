package com.qingfeng.fm.controller;

import com.qingfeng.fm.entity.ShoppingCart;
import com.qingfeng.fm.service.ShoppingCartService;
import com.qingfeng.fm.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation("用户添加购物车接口")
    @PostMapping("/add")
    public ResultVO addShoppingCart(@RequestBody ShoppingCart cart,
                                    @RequestHeader("token") String token){
        ResultVO resultVO = shoppingCartService.addShoppingCart(cart);
        return resultVO;
    }

    @ApiOperation("用户查询购物车接口")
    @GetMapping("/list")
    @ApiImplicitParam(dataType = "int",name="userId",value="用户Id",required = true)
    public ResultVO list(Integer userId,@RequestHeader("token")String token){
        ResultVO resultVO = null;
        if (userId != null){
            resultVO = shoppingCartService.listShoppingCartByUserId(userId);
        }
        return resultVO;
    }

    @ApiOperation("根据购物车Id修改购物车数量的接口")
    @PutMapping("/update/{cid}/{cnum}")
    public ResultVO updateNum(@PathVariable("cid") Integer cartId,
                              @PathVariable("cnum") Integer cartNum,
                              @RequestHeader("token") String token) {
        ResultVO resultVO = shoppingCartService.updateCartNum(cartId, cartNum);
        return resultVO;
    }

    @ApiOperation("根据购物车Id删除对应的商品信息接口")
    @GetMapping("/delete/{cid}")
    public ResultVO deleteByCartId(@PathVariable("cid") Integer cartId,
                                   @RequestHeader("token") String token){
        ResultVO resultVO = shoppingCartService.deleteByCartId(cartId);
        return resultVO;
    }

    @ApiOperation("根据购物车Id查询对应的商品信息接口")
    @GetMapping("/listbycids")
    @ApiImplicitParam(dataType="String",name="cids",value="选择的购物车记录的Id",required = true)
    public ResultVO listByCids(String cids,@RequestHeader("token") String token){
        ResultVO resultVO = shoppingCartService.listShoppingCartsByCids(cids);
        return resultVO;
    }
}
