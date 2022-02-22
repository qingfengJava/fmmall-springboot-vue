package com.qingfeng.stock.service.impl;

import com.qingfeng.fm.entity.ProductSku;
import com.qingfeng.stock.dao.ProductSkuMapper;
import com.qingfeng.stock.service.StockUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/21
 */
@Service
public class StockUpdateServiceImpl implements StockUpdateService {

    @Autowired
    private ProductSkuMapper productSkuMapper;

    @Override
    public int updateStock(List<ProductSku> skus) {
        int count = 1;
        for (ProductSku productSku : skus) {
            //根据主键来修改属性值
            int i = productSkuMapper.updateByPrimaryKeySelective(productSku);
            count *= i;
        }
        return count;
    }
}
