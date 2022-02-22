package com.qingfeng.shopcart.service.impl;

import com.qingfeng.shopcart.dao.ShoppingCartMapper;
import com.qingfeng.shopcart.service.ShopCartDelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/21
 */
@Service
public class ShopCartDelServiceImpl implements ShopCartDelService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public int deleteShopCart(String cids) {
        int count = 1;
        String[] arr = cids.split(",");
        for (int i = 0; i < arr.length; i++) {
            int cid = Integer.parseInt(arr[i]);
            //6、删除购物车：当购物车中的记录购买成功之后，购物车中对应做删除操作
            int j = shoppingCartMapper.deleteByPrimaryKey(cid);
            count *= j;
        }

        return count;
    }
}
