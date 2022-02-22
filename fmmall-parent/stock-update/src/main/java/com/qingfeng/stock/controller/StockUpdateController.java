package com.qingfeng.stock.controller;

import com.qingfeng.fm.entity.ProductSku;
import com.qingfeng.stock.service.StockUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/21
 */
@RestController
public class StockUpdateController {

    @Autowired
    private StockUpdateService stockUpdateService;

    @PutMapping("/stock/update")
    public int update(@RequestBody List<ProductSku> skus){
        return stockUpdateService.updateStock(skus);
    }
}
