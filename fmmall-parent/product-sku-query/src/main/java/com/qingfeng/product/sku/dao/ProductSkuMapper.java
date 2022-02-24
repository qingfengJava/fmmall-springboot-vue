package com.qingfeng.product.sku.dao;

import com.qingfeng.fm.entity.ProductSku;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/24
 */
@Repository
public interface ProductSkuMapper extends Mapper<ProductSku>, MySqlMapper<ProductSku> {
}
