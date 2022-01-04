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

    /**
     * 根据商品Id查询商品基本信息
     * @param productId
     * @return
     */
    public ResultVO getProductBasicInfo(String productId);

    /**
     * 根据商品id，查询商品详情信息
     * @param productId
     * @return
     */
    public ResultVO getProductParamsById(String productId);

    /***
     * 按照三级分类的id分页查询此分类下的商品信息
     * @param categoryId
     * @param pageNum
     * @param limit
     * @return
     */
    public ResultVO getProductsByCategoryId(int categoryId,int pageNum,int limit);

    /**
     * 根据类别Id，查询类别对应的品牌
     * @param categoryId
     * @return
     */
    public ResultVO listBrands(int categoryId);

    /**
     * 根据嘎UN就爱你自i，分页搜索商品信息
     * @param kw
     * @param pageNum
     * @param limit
     * @return
     */
    public ResultVO searchProduct(String kw,int pageNum,int limit);

    /**
     * 根据搜索关键字，查询类别对应的品牌
     * @param kw
     * @return
     */
    public ResultVO listBrands(String kw);
}
