package com.qingfeng.fm.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingfeng.fm.dao.ProductImgMapper;
import com.qingfeng.fm.dao.ProductMapper;
import com.qingfeng.fm.dao.ProductParamsMapper;
import com.qingfeng.fm.dao.ProductSkuMapper;
import com.qingfeng.fm.entity.*;
import com.qingfeng.fm.service.ProductService;
import com.qingfeng.fm.utils.PageHelper;
import com.qingfeng.fm.vo.ResStatus;
import com.qingfeng.fm.vo.ResultVO;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/12/7
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductImgMapper productImgMapper;
    @Autowired
    private ProductSkuMapper productSkuMapper;
    @Autowired
    private ProductParamsMapper productParamsMapper;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 注入redis
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public ResultVO listRecommendProducts() {
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", productVOS);
        return resultVO;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ResultVO getProductBasicInfo(String productId) {
        try {
            //①根据商品Id查询redis
            String productInfo = (String) stringRedisTemplate.boundHashOps("products").get(productId);
            //②如果redis中查询到了商品信息，则直接返回给控制器
            if(productInfo != null){
                Product product = new ObjectMapper().readValue(productInfo, Product.class);

                // 从redis中查询商品的图片
                String imgsStr = (String) stringRedisTemplate.boundHashOps("productImgs").get(productId);
                JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, ProductImg.class);
                List<ProductImg> productImgs = objectMapper.readValue(imgsStr,javaType);
                // 从redis中查询此商品的套餐
                String skusStr = (String) stringRedisTemplate.boundHashOps("productSkus").get(productId);
                JavaType javaType2 = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, ProductSku.class);
                List<ProductSku> productSkus = objectMapper.readValue(skusStr,javaType2);

                //创建HashMap 封装商品、图片及套餐
                HashMap<String,Object> basicInfo = new HashMap<String,Object>();
                basicInfo.put("product",product);
                basicInfo.put("productImgs",productImgs);
                basicInfo.put("productSkus",productSkus);
                return new ResultVO(ResStatus.OK,"success",basicInfo);
            }else{
                //③如果redis中没有查询到商品信息，则查询数据库
                //1、商品基本信息
                Example example = new Example(Product.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("productId",productId);
                //状态必须要为1才能查询  状态为1表示上架商品
                criteria.andEqualTo("productStatus",1);
                //进行查询
                List<Product> products = productMapper.selectByExample(example);
                if (products.size() > 0){
                    //将从数据库查询到的数据写入到redis
                    Product product = products.get(0);
                    String jsonStr = objectMapper.writeValueAsString(product);
                    stringRedisTemplate.boundHashOps("products").put(productId,jsonStr);

                    //说明存在，进行后续操作
                    //2、根据商品Id查询商品图片
                    Example example1 = new Example(ProductImg.class);
                    Example.Criteria criteria1 = example1.createCriteria();
                    criteria1.andEqualTo("itemId",productId);
                    List<ProductImg> productImgs = productImgMapper.selectByExample(example1);
                    stringRedisTemplate.boundHashOps("productImgs").put(productId,objectMapper.writeValueAsString(productImgs));

                    //3、根据商品Id查询商品套餐
                    Example example2 = new Example(ProductSku.class);
                    Example.Criteria criteria2 = example2.createCriteria();
                    criteria2.andEqualTo("productId",productId);
                    criteria2.andEqualTo("status",1);
                    List<ProductSku> productSkus = productSkuMapper.selectByExample(example2);
                    stringRedisTemplate.boundHashOps("productSkus").put(productId,objectMapper.writeValueAsString(productSkus));

                    //创建HashMap存放我们的信息
                    HashMap<String,Object> basicInfo = new HashMap<String,Object>();
                    basicInfo.put("product",products.get(0));
                    basicInfo.put("productImgs",productImgs);
                    basicInfo.put("productSkus",productSkus);
                    return new ResultVO(ResStatus.OK,"success",basicInfo);
                }else {
                    //不存在
                    return new ResultVO(ResStatus.NO,"查询的商品不存在！",null);
                }
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultVO getProductParamsById(String productId) {
        Example example = new Example(ProductParams.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",productId);
        List<ProductParams> productParams = productParamsMapper.selectByExample(example);
        if (productParams.size() > 0){
            return new ResultVO(ResStatus.OK,"success",productParams.get(0));
        }else {
            return new ResultVO(ResStatus.NO,"此商品可能为三无产品",null);
        }
    }

    @Override
    public ResultVO getProductsByCategoryId(int categoryId, int pageNum, int limit) {
        //1、查询分页数据
        int start = (pageNum - 1)*limit;
        List<ProductVO> productVOS = productMapper.selectProductByCategoryId(categoryId,start, limit);
        //2、查询当前类别下的商品的总记录数
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryId",categoryId);
        int count = productMapper.selectCountByExample(example);
        //3、计算总页数
        int pageCount = count % limit == 0 ? count/limit : count/limit+1;
        //4、封装返回数据
        PageHelper<ProductVO> pageHelper = new PageHelper<>(count, pageCount, productVOS);
        return new ResultVO(ResStatus.OK,"success",pageHelper);
    }

    @Override
    public ResultVO listBrands(int categoryId) {
        List<String> brands = productMapper.selectBrandByCategoryId(categoryId);
        return new ResultVO(ResStatus.OK,"success",brands);
    }

    @Override
    public ResultVO searchProduct(String kw, int pageNum, int limit) {
        ResultVO resultVO = null;
        try {
            //1、查询搜素结果
            int start = (pageNum-1)*limit;
            //List<ProductVO> productVOS = productMapper.selectProductByKeyword(kw, start, limit);
            //代码优化，从ES中检索数据
            SearchRequest searchRequest = new SearchRequest("fmmallproductsindex");
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            //查询条件
            searchSourceBuilder.query(QueryBuilders.multiMatchQuery(kw,"productName","productSkuName"));
            //分页条件
            searchSourceBuilder.from(start);
            searchSourceBuilder.size(limit);
            //高亮显示
            HighlightBuilder highlightBuilder = new HighlightBuilder();
            HighlightBuilder.Field field = new HighlightBuilder.Field("productName");
            HighlightBuilder.Field field2 = new HighlightBuilder.Field("productSkuName");
            highlightBuilder.field(field);
            highlightBuilder.field(field2);
            highlightBuilder.preTags("<label style='color:red'>");
            highlightBuilder.postTags("</label>");
            searchSourceBuilder.highlighter(highlightBuilder);
            searchRequest.source(searchSourceBuilder);
            //执行检索
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

            //封装查询结果
            SearchHits hits = searchResponse.getHits();
            //得到总记录数
            int count = (int) hits.getTotalHits().value;
            //计算总页数
            int pageCount = count%limit==0? count/limit:count/limit+1;

            Iterator<SearchHit> iterator = hits.iterator();
            List<ProductEs> products = new ArrayList<>();
            while (iterator.hasNext()){
                SearchHit searchHit = iterator.next();
                ProductEs productEs = objectMapper.readValue(searchHit.getSourceAsString(), ProductEs.class);
                //获取高亮字段
                Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
                //productName
                HighlightField highlightField = highlightFields.get("productName");
                if (highlightField != null){
                    String highLightProductName = Arrays.toString(highlightField.fragments());
                    highLightProductName = highLightProductName.substring(highLightProductName.indexOf("[")+1,highLightProductName.indexOf("]"));
                    productEs.setProductName(highLightProductName);
                }
                HighlightField highlightField2 = highlightFields.get("productSkuName");
                if (highlightField2 != null){
                    String highLightProductSkuName = Arrays.toString(highlightField2.fragments());
                    highLightProductSkuName=highLightProductSkuName.substring(highLightProductSkuName.indexOf("[")+1,highLightProductSkuName.lastIndexOf("]"));
                    productEs.setProductSkuName(highLightProductSkuName);
                }

                products.add(productEs);
            }

            //4、封装，返回数据
            PageHelper<ProductEs> pageHelper = new PageHelper<>(count, pageCount, products);
            resultVO = new ResultVO(ResStatus.OK,"SUCCESS",pageHelper);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultVO;
    }

    @Override
    public ResultVO listBrands(String kw) {
        kw = "%"+kw+"%";
        List<String> brands = productMapper.selectBrandByKeyWord(kw);
        return new ResultVO(ResStatus.OK,"SUCCESS", brands);
    }
}
