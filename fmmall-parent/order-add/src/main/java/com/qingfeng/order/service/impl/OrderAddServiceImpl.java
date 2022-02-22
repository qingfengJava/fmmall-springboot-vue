package com.qingfeng.order.service.impl;

import com.qingfeng.fm.entity.Orders;
import com.qingfeng.fm.entity.ShoppingCartVO;
import com.qingfeng.order.dao.OrdersMapper;
import com.qingfeng.order.service.OrderAddService;
import com.qingfeng.order.service.feign.StockQueryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/22
 */
@Service
public class OrderAddServiceImpl implements OrderAddService {

    @Autowired
    private StockQueryClient stockQueryClient;
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<ShoppingCartVO> save(Orders order, String cids) {
        //1、校验库存
        //a、调用stock-query服务查询当前订单中包含的购物车信息
        List<ShoppingCartVO>list = stockQueryClient.query(cids);
        if (list != null && list.size() != 0) {
            boolean f = true;
            String untitled = "";
            for (ShoppingCartVO sc : list) {
                if (Integer.parseInt(sc.getCartNum()) > sc.getSkuStock()) {
                    f = false;
                    break;
                }
                //获取所有商品的名称，以逗号拼接成字符串
                untitled = untitled + sc.getProductName() + ",";
            }

            if (f){
                //库存充足 保存订单信息
                order.setUntitled(untitled);
                order.setCreateTime(new Date());
                order.setStatus("1");

                //保存订单
                int i = ordersMapper.insert(order);
                if(i > 0){
                    return list;
                }
            }
        }

        //不成功的都返回null
        return null;
    }
}
