package com.qingfeng.fm.service.impl;

import com.qingfeng.fm.dao.CategoryMapper;
import com.qingfeng.fm.entity.CategoryVO;
import com.qingfeng.fm.service.CategoryService;
import com.qingfeng.fm.vo.ResStatus;
import com.qingfeng.fm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 列表查询的业务层接口实现
 *
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/11/26
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询分类列表（包含三个级别的分类）
     * @return
     */
    @Override
    public ResultVO listCategories() {
        //调用mapper查询所有的列表信息
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories();
        //将信息封装到resultVO中
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", categoryVOS);
        return resultVO;
    }

    /**
     * 查询所有的一级分类，同时查询当前一级分类下销量最高的6个商品
     * @return
     */
    @Override
    public ResultVO listFirstLevelCategories() {
        List<CategoryVO> categoryVOS = categoryMapper.selectFirstLevelCategories();
        //将信息封装到resultVO中
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", categoryVOS);
        return resultVO;
    }
}
