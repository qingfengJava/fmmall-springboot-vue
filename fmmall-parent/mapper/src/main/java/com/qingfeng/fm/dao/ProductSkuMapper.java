package com.qingfeng.fm.dao;

import com.qingfeng.fm.entity.ProductSku;
import com.qingfeng.fm.generaldao.GeneralDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 清风学Java
 */
@Repository
public interface ProductSkuMapper extends GeneralDao<ProductSku> {

    /**
     * 根据商品Id，查询当前商品所有套餐中价格最低的套餐
     * @param productId
     * @return
     */
    public List<ProductSku> selectLowerestPriceByProductId(String productId);
}