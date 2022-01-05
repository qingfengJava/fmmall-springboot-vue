package com.qingfeng.fm.service;

import com.qingfeng.fm.entity.Orders;
import com.qingfeng.fm.vo.ResultVO;

import java.util.Map;

/**
 * 订单的业务层接口
 *
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/12/24
 */
public interface OrderService {

    /**
     * 添加订单
     * @param cids
     * @param orders
     * @return
     */
    public Map<String, String> addOrder(String cids, Orders orders);

    /**
     * 修改订单操作
     * @param orderId
     * @param status
     * @return
     */
    public int updateOrderStatus(String orderId, String status);

    /**
     * 根据订单Id查询订单信息
     * @param orderId
     * @return
     */
    public ResultVO getOrderById(String orderId);

    /**
     * 订单超时，关闭订单
     * @param orderId
     */
    public void closeOrder(String orderId);

    /**
     * 根据用户Id查询订单信息
     * @param userId
     * @param status
     * @param pageNum
     * @param limit
     * @return
     */
    public ResultVO listOrder(String userId,String status,int pageNum,int limit);
}
