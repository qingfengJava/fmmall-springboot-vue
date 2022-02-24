package com.qingfeng.order.service.impl;

import com.qingfeng.fm.beans.OrderItem;
import com.qingfeng.fm.beans.Orders;
import com.qingfeng.fm.beans.ProductSku;
import com.qingfeng.order.service.OrderCloseService;
import com.qingfeng.order.service.feigin.OrderItemQueryClient;
import com.qingfeng.order.service.feigin.OrderStatusUpdateClient;
import com.qingfeng.order.service.feigin.ProductSkuQueryClient;
import com.qingfeng.order.service.feigin.StockUpdateClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 关闭订单服务
 *
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/23
 */
@Service
public class OrderCloseServiceImpl implements OrderCloseService {

    @Autowired
    private OrderStatusUpdateClient orderStatusUpdateClient;
    @Autowired
    private OrderItemQueryClient orderItemQueryClient;
    @Autowired
    private ProductSkuQueryClient productSkuQueryClient;
    @Autowired
    private StockUpdateClient stockUpdateClient;

    @Override
    public int closeOrder(String orderId,int closeType) {
        //1、调用 order-status-update 服务 修改订单状态为6 closeType为1，超时关闭
        Orders order = new Orders();
        order.setOrderId(orderId);
        order.setStatus("6");
        order.setCloseType(closeType);
        int i = orderStatusUpdateClient.update(order);
        if (i > 0){
            //2、调用orderitem-query 服务 查询当前订单包含的商品信息（订单快照）
            List<OrderItem> orderItems = orderItemQueryClient.query(orderId);

            //3、还原库存：调用stock-update服务  修改商品库存
            if (orderItems != null && orderItems.size() > 0){
                List<ProductSku> skus = new ArrayList<>();
                for (OrderItem orderItem : orderItems) {
                    String skuId = orderItem.getSkuId();
                    //product-sku-query 服务根据skuId查询当前商品的套餐信息（套餐信息中包含库存）
                    ProductSku sku = productSkuQueryClient.query(skuId);
                    int newStock = sku.getStock() + orderItem.getBuyCounts();
                    sku.setStock(newStock);
                    skus.add(sku);
                }
                //调用stock-update服务进行库存修改
                int j = stockUpdateClient.update(skus);
                return j;
            }
        }

        return 0;
    }
}
