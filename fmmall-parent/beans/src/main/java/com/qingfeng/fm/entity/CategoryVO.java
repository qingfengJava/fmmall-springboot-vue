package com.qingfeng.fm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 首页类别商品推荐实体类
 *
 * @author 清风学Java
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryVO {

    private Integer categoryId;

    private String categoryName;

    private Integer categoryLevel;

    private Integer parentId;

    private String categoryIcon;

    private String categorySlogan;

    private String categoryPic;

    private String categoryBgColor;

    /**
     * 用于存放当前分类的子分类
     * 实现首页的类别显示
     */
    private List<CategoryVO> categories;

    /**
     * 存储每个类别下的商品信息
     */
    private List<Product> products;

}