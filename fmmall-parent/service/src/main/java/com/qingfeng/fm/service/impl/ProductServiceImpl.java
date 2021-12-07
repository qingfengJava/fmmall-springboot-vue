package com.qingfeng.fm.service.impl;

import com.qingfeng.fm.dao.ProductMapper;
import com.qingfeng.fm.entity.ProductVO;
import com.qingfeng.fm.service.ProductService;
import com.qingfeng.fm.vo.ResStatus;
import com.qingfeng.fm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public ResultVO listRecommendProducts() {
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", productVOS);
        return resultVO;
    }
}
