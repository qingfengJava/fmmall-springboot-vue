package com.qingfeng.fm.service;

import com.qingfeng.fm.vo.ResultVO;

/**
 * 列表查询的业务层接口
 *
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/11/26
 */
public interface CategoryService {

    /**
     * 查询所有列表
     * @return
     */
    public ResultVO listCategories();

    /**
     * 查询一级类别  会包含商品对象
     * @return
     */
    public ResultVO listFirstLevelCategories();
}
