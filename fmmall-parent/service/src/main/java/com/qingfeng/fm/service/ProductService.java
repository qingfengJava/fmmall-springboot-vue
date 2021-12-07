package com.qingfeng.fm.service;

import com.qingfeng.fm.vo.ResultVO;

/**
 * 商品的业务层接口
 *
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/12/7
 */
public interface ProductService {

    /**
     * 商品推荐
     * @return
     */
    public ResultVO listRecommendProducts();
}
