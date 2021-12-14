package com.qingfeng.fm.controller;

import com.qingfeng.fm.service.ProductService;
import com.qingfeng.fm.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/12/11
 */
@RestController
@CrossOrigin
@RequestMapping("/product")
@Api(value = "提供商品信息相关的接口",tags="商品管理")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("商品基本信息查询接口")
    @GetMapping("/detail-info/{pid}")
    public ResultVO getProductBasicInfo(@PathVariable("pid") String pid){
        return productService.getProductBasicInfo(pid);
    }

    @ApiOperation("商品参数信息查询接口")
    @GetMapping("/detail-params/{pid}")
    public ResultVO getProductParams(@PathVariable("pid") String pid){
        return productService.getProductParamsById(pid);
    }
}
