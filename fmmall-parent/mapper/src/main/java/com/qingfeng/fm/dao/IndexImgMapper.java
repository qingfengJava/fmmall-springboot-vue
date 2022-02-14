package com.qingfeng.fm.dao;

import com.qingfeng.fm.entity.IndexImg;
import com.qingfeng.fm.generaldao.GeneralDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/11/23
 */
@Repository
public interface IndexImgMapper extends GeneralDao<IndexImg> {

    /**
     * 1、查询轮播图信息：查询status=1 且 按照seq进行排序
     * @return
     */
    public List<IndexImg> listIndexImgs();
}