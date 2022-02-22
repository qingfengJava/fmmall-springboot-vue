package com.qingfeng.orderitem.dao;

import com.qingfeng.fm.entity.OrderItem;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/21
 */
@Repository
public interface OrderItemMapper extends Mapper<OrderItem> , MySqlMapper<OrderItem> {

}
