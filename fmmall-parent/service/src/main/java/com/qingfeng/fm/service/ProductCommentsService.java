package com.qingfeng.fm.service;

import com.qingfeng.fm.vo.ResultVO;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/12/16
 */
public interface ProductCommentsService {

    /**
     * 根据商品Id分页查询商品对应的评论信息
     * @param productId 商品Id
     * @param pageNum 查询页码
     * @param limit 每页显示条数
     * @return
     */
    public ResultVO listCommentsByProductId(String productId,int pageNum,int limit);

    /**
     * 根据商品Id统计当前商品的评论信息
     * @param productId
     * @return
     */
    public ResultVO getCommentsCountByProductId(String productId);
}
