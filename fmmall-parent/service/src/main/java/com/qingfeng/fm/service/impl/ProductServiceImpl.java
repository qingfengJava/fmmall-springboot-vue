package com.qingfeng.fm.service.impl;

import com.qingfeng.fm.dao.ProductImgMapper;
import com.qingfeng.fm.dao.ProductMapper;
import com.qingfeng.fm.dao.ProductParamsMapper;
import com.qingfeng.fm.dao.ProductSkuMapper;
import com.qingfeng.fm.entity.*;
import com.qingfeng.fm.service.ProductService;
import com.qingfeng.fm.vo.ResStatus;
import com.qingfeng.fm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/12/7
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductImgMapper productImgMapper;
    @Autowired
    private ProductSkuMapper productSkuMapper;
    @Autowired
    private ProductParamsMapper productParamsMapper;


    @Override
    public ResultVO listRecommendProducts() {
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", productVOS);
        return resultVO;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ResultVO getProductBasicInfo(String productId) {
        //1、商品基本信息
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",productId);
        //状态必须要为1才能查询  状态为1表示上架商品
        criteria.andEqualTo("productStatus",1);
        //进行查询
        List<Product> products = productMapper.selectByExample(example);
        if (products.size() > 0){
            //说明存在，进行后续操作
            //2、商品图片
            Example example1 = new Example(ProductImg.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("itemId",productId);
            List<ProductImg> productImgs = productImgMapper.selectByExample(example1);
            //3、商品套餐
            Example example2 = new Example(ProductSku.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("productId",productId);
            criteria2.andEqualTo("status",1);
            List<ProductSku> productSkus = productSkuMapper.selectByExample(example2);

            //创建HashMap存放我们的信息
            HashMap<String,Object> basicInfo = new HashMap<String,Object>();
            basicInfo.put("product",products.get(0));
            basicInfo.put("productImgs",productImgs);
            basicInfo.put("productSkus",productSkus);
            return new ResultVO(ResStatus.OK,"success",basicInfo);
        }else {
            //不存在
            return new ResultVO(ResStatus.NO,"查询的商品不存在！",null);
        }
    }

    @Override
    public ResultVO getProductParamsById(String productId) {
        Example example = new Example(ProductParams.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",productId);
        List<ProductParams> productParams = productParamsMapper.selectByExample(example);
        if (productParams.size() > 0){
            return new ResultVO(ResStatus.OK,"success",productParams.get(0));
        }else {
            return new ResultVO(ResStatus.NO,"此商品可能为三无产品",null);
        }
    }
}
