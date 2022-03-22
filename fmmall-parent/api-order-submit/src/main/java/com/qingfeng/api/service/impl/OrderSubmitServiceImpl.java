package com.qingfeng.api.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.qingfeng.api.service.OrderSubmitService;
import com.qingfeng.api.service.feign.OrderAddClient;
import com.qingfeng.api.service.feign.OrderitemAddClient;
import com.qingfeng.api.service.feign.ShopcartDelClient;
import com.qingfeng.api.service.feign.StockUpdateClient;
import com.qingfeng.fm.beans.Orders;
import com.qingfeng.fm.beans.ProductSku;
import com.qingfeng.fm.beans.ShoppingCartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/22
 */
@Service
public class OrderSubmitServiceImpl implements OrderSubmitService {

    @Autowired
    private OrderAddClient orderAddClient;
    @Autowired
    private OrderitemAddClient orderitemAddClient;
    @Autowired
    private StockUpdateClient stockUpdateClient;
    @Autowired
    private ShopcartDelClient shopcartDelClient;

    @Override
    @Transactional
    @LcnTransaction
    public Map<String, String> addOrder(String cids, Orders order) {
        Map<String, String> map = null;
        //1、保存订单（校验库存）  order-add服务
        //生成订单编号
        String orderId = UUID.randomUUID().toString().replace("-","");
        order.setOrderId(orderId);
        List<ShoppingCartVO> carts = orderAddClient.saveOrder(order, cids);

        //2、保存订单快照  orderitem-add
        if (carts != null){
            int i = orderitemAddClient.addOrderItem(carts, orderId);
            System.out.println(i);

            //3、修改库存 stock-update
            if(i > 0){
                //将购物车中的商品 及要修改的库存封装到ProductSku中
                List<ProductSku> skus = new ArrayList<>();
                for (ShoppingCartVO sc : carts) {
                    String skuId = sc.getSkuId();
                    int newStock = sc.getSkuStock() - Integer.parseInt(sc.getCartNum());

                    ProductSku productSku = new ProductSku();
                    productSku.setSkuId(skuId);
                    productSku.setStock(newStock);
                    skus.add(productSku);
                }

                //调用服务
                int j = stockUpdateClient.update(skus);
                //4、删除购物车 shopcart-del
                if (j > 0){
                    int k = shopcartDelClient.delete(cids);
                    if (k > 0){
                        map = new HashMap<>(10);
                        map.put("orderId", orderId);
                        String str = "";
                        for (int index = 0; index < carts.size(); index++) {
                            str += carts.get(index).getSkuName();
                            str = index ==carts.size()-1 ? str:str+",";
                        }
                        map.put("productNames", str);
                    }
                }
            }
        }

        return map;
    }
}
