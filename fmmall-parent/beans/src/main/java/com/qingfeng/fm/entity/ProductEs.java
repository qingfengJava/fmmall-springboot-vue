package com.qingfeng.fm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductEs {

    private String productId;
    private String productName;
    private String productImg;
    private int soldNum;
    private String productSkuName;
    private double productSkuPrice;
}
