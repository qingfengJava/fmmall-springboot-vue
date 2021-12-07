package com.qingfeng.fm.dao;

import com.qingfeng.fm.entity.Product;
import com.qingfeng.fm.entity.ProductVO;
import com.qingfeng.fm.generaldao.GeneralDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 */
@Repository
public interface ProductMapper extends GeneralDao<Product> {

    /**
     * 查询推荐商品
     * @return
     */
    public List<ProductVO> selectRecommendProducts();
}