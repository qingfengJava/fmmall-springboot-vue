package com.qingfeng.fm.dao;

import com.qingfeng.fm.entity.Orders;
import com.qingfeng.fm.entity.OrdersVO;
import com.qingfeng.fm.generaldao.GeneralDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 清风学Java
 */
@Repository
public interface OrdersMapper extends GeneralDao<Orders> {

    /**
     * 根据用户Id查询用户对应的订单
     * @param userId
     * @param status
     * @return
     */
    public List<OrdersVO> selectOrders(@Param("userId") String userId,
                                       @Param("status") String status,
                                       @Param("start") int start,
                                       @Param("limit") int limit);
}