package com.qingfeng.fm.dao;

import com.qingfeng.fm.entity.Category;
import com.qingfeng.fm.entity.CategoryVO;
import com.qingfeng.fm.generaldao.GeneralDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品种类持久层
 *
 * @author 清风学Java
 */
@Repository
public interface CategoryMapper extends GeneralDao<Category> {

    /**
     * 使用连接查询实现分类查询
     * 查询所有的商品种类
     * @return
     */
    public List<CategoryVO> selectAllCategories();

    /**
     * 使用子查询实现分类查询：根据parentId查询子分类
     * 查询所有的商品种类
     *
     * @param parentId 父id
     * @return
     */
    public List<CategoryVO> selectAllCategories2(int parentId);

    /**
     * 查询一级类别
     * @return
     */
    public List<CategoryVO> selectFirstLevelCategories();
}