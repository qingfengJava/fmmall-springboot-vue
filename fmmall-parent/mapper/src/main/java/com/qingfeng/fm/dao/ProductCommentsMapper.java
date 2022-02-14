package com.qingfeng.fm.dao;

import com.qingfeng.fm.entity.ProductComments;
import com.qingfeng.fm.entity.ProductCommentsVO;
import com.qingfeng.fm.generaldao.GeneralDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 清风学Java
 */
@Repository
public interface ProductCommentsMapper extends GeneralDao<ProductComments> {

    /**
     * 根据商品Id，查询商品对应的评论
     * @param productId 商品Id
     * @param start 其实索引
     * @param limit 查询条数
     * @return
     */
    public List<ProductCommentsVO> selectCommentsByProductId(@Param("productId") String productId,
                                                             @Param("start") int start,
                                                             @Param("limit") int limit);

}