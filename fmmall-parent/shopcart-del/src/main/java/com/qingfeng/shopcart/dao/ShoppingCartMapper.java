package com.qingfeng.shopcart.dao;

import com.qingfeng.fm.entity.ShoppingCart;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/21
 */
@Repository
public interface ShoppingCartMapper extends Mapper<ShoppingCart>, MySqlMapper<ShoppingCart> {
}
