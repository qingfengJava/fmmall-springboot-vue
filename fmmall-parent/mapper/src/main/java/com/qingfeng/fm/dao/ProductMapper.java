package com.qingfeng.fm.dao;

import com.qingfeng.fm.entity.Product;
import com.qingfeng.fm.entity.ProductVO;
import com.qingfeng.fm.generaldao.GeneralDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 清风学java
 */
@Repository
public interface ProductMapper extends GeneralDao<Product> {

    /**
     * 查询推荐商品
     * @return
     */
    public List<ProductVO> selectRecommendProducts();

    /**
     * 查询指定一级类别下销量最高的6个商品
     * @param cid
     * @return
     */
    public List<ProductVO> selectTop6ByCategory(int cid);

    /**
     * 根据三级分类id和品牌分页查询商品信息
     * @param cid 三级分类id
     * @param start 起始索引
     * @param limit 查询记录数
     * @return
     */
    public List<ProductVO> selectProductByCategoryId(@Param("cid") int cid,
                                                     @Param("start") int start,
                                                     @Param("limit") int limit);

    /**
     * 根据类别Id查询类别对应的品牌
     * @param cid
     * @return
     */
    public List<String> selectBrandByCategoryId(int cid);

    /**
     * 根据关键字模糊搜素商品信息
     * @param kw
     * @param start
     * @param limit
     * @return
     */
    public List<ProductVO> selectProductByKeyword(@Param("kw") String kw,
                                                  @Param("start") int start,
                                                  @Param("limit") int limit);

    /**
     * 查询全部的商品信息
     * @return
     */
    public List<ProductVO> selectProducts();

    /**
     * 根据搜索关键字查询相关商品的品牌列表
     * @param kw
     * @return
     */
    public List<String> selectBrandByKeyWord(String kw);
}