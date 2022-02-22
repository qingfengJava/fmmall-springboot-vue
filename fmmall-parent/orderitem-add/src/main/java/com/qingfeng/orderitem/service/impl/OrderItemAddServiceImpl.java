package com.qingfeng.orderitem.service.impl;

import com.qingfeng.fm.entity.OrderItem;
import com.qingfeng.fm.entity.ShoppingCartVO;
import com.qingfeng.orderitem.dao.OrderItemMapper;
import com.qingfeng.orderitem.service.OrderItemAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/21
 */
@Service
public class OrderItemAddServiceImpl implements OrderItemAddService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public int save(List<ShoppingCartVO> list, String orderId) {
        int count = 1;
        for (ShoppingCartVO sc : list) {
            int cnum = Integer.parseInt(sc.getCartNum());
            String itemId = System.currentTimeMillis() + "" + (new Random().nextInt(89999) + 10000);
            OrderItem orderItem = new OrderItem(itemId, orderId, sc.getProductId(), sc.getProductName(), sc.getProductImg(), sc.getSkuId(),
                    sc.getSkuName(), new BigDecimal(sc.getSellPrice()), cnum, new BigDecimal(sc.getSellPrice() * cnum), new Date(), new Date(), 0);
            int i = orderItemMapper.insert(orderItem);
            count *= i;
        }
        return count;
    }
}
