package com.qingfeng.fm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 新增productName、productImg
 *
 * @author 清风学Java
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShoppingCartVO {
    /**
     * 主键
     */
    private Integer cartId;

    /**
     * 商品ID
     */
    private String productId;

    /**
     * skuID
     */
    private String skuId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 购物车商品数量
     */
    private String cartNum;

    /**
     * 添加购物车时间
     */
    private String cartTime;

    /**
     * 添加购物车时商品价格
     */
    private BigDecimal productPrice;

    /**
     * 选择的套餐的属性
     */
    private String skuProps;

    private String productName;
    private String productImg;
    private Double originalPrice;
    private Double sellPrice;
    private String skuName;
}