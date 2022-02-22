package com.qingfeng.stock.service.impl;

import com.qingfeng.fm.entity.ShoppingCartVO;
import com.qingfeng.stock.dao.ShopCartMapper;
import com.qingfeng.stock.service.StockQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/21
 */
@Service
public class StockQueryServiceImpl implements StockQueryService {

    @Autowired
    private ShopCartMapper shopCartMapper;

    @Override
    public List<ShoppingCartVO> selectShopCartByCids(String cids) {
        String[] arr = cids.split(",");
        List<Integer> cidsList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            cidsList.add(Integer.parseInt(arr[i]));
        }
        List<ShoppingCartVO> list = shopCartMapper.selectShopCartByCids(cidsList);
        return list;
    }
}
