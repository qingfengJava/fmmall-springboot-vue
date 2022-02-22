package com.qingfeng.stock.controller;

import com.qingfeng.fm.entity.ShoppingCartVO;
import com.qingfeng.stock.service.StockQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/21
 */
@RestController
public class StockQueryController {

    @Autowired
    private StockQueryService stockQueryService;

    @GetMapping("stock/query")
    public List<ShoppingCartVO> query(String cids){
        List<ShoppingCartVO> list = stockQueryService.selectShopCartByCids(cids);
        return list;
    }
}
