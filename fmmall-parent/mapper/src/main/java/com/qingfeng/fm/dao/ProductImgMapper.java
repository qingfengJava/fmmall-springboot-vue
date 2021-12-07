package com.qingfeng.fm.dao;

import com.qingfeng.fm.entity.ProductImg;
import com.qingfeng.fm.generaldao.GeneralDao;

import java.util.List;

/**
 * @author Administrator
 */
public interface ProductImgMapper extends GeneralDao<ProductImg> {

    /**
     * 根据商品id查询当前商品图片信息
     * @param productId
     * @return
     */
    public List<ProductImg> selectProductImgByProductId(int productId);
}