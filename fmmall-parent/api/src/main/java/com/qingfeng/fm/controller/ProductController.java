package com.qingfeng.fm.controller;

import com.qingfeng.fm.service.ProductCommentsService;
import com.qingfeng.fm.service.ProductService;
import com.qingfeng.fm.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
    @Autowired
    private ProductCommentsService productCommentsService;

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

    @ApiOperation("商品评论信息分页查询接口")
    @GetMapping("/detail-comments/{pid}")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name="pageNum", value = "当前页码",required = true),
            @ApiImplicitParam(dataType = "int",name="limit", value = "每页显示条数",required = true)
    })
    public ResultVO getProductComments(@PathVariable("pid") String pid,int pageNum,int limit){
        return productCommentsService.listCommentsByProductId(pid,pageNum,limit);
    }

    @ApiOperation("商品评价统计查接口")
    @GetMapping("/detail-commentscount/{pid}")
    public ResultVO getProductCommentsCount(@PathVariable("pid") String pid){
        return productCommentsService.getCommentsCountByProductId(pid);
    }

    @ApiOperation("根据类别查询商品接口")
    @GetMapping("/listbycid/{cid}")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name="pageNum", value = "当前页码",required = true),
            @ApiImplicitParam(dataType = "int",name="limit", value = "每页显示条数",required = true)
    })
    public ResultVO getProductsByCategoryId(@PathVariable("cid") int cid,int pageNum,int limit){
        return productService.getProductsByCategoryId(cid,pageNum,limit);
    }

    @ApiOperation("根据类别查询商品品牌接口")
    @GetMapping("/listbrands/{cid}")
    public ResultVO getBrandsByCategoryId(@PathVariable("cid") int cid){
        return productService.listBrands(cid);
    }

    @ApiOperation("根据关键字查询商品接口")
    @GetMapping("/listbykeyword")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name="keyword", value = "搜索的关键字",required = true),
            @ApiImplicitParam(dataType = "int",name="pageNum", value = "当前页码",required = true),
            @ApiImplicitParam(dataType = "int",name="limit", value = "每页显示条数",required = true)
    })
    public ResultVO searchProducts(String keyword,int pageNum,int limit){
        return productService.searchProduct(keyword,pageNum,limit);
    }

    @ApiOperation("根据关键字查询商品品牌接口")
    @GetMapping("/listbrands-keyword")
    @ApiImplicitParam(dataType = "string",name="keyword", value = "搜索的关键字",required = true)
    public ResultVO getBrandsByKeyWords(String keyword){
        return productService.listBrands(keyword);
    }

}
