package com.qingfeng;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingfeng.fm.ApiApplication;
import com.qingfeng.fm.dao.ProductMapper;
import com.qingfeng.fm.entity.ProductEs;
import com.qingfeng.fm.entity.ProductSku;
import com.qingfeng.fm.entity.ProductVO;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class ImportProductInfoIntoESTest {

    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateIndex() throws IOException {
        //创建索引
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("fmmallproductsindex");
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse.isAcknowledged());
    }

    @Test
    public void testImportIndex() throws IOException {
        //1、从数据库中查询数据
        List<ProductVO> productVOS = productMapper.selectProducts();

        //2、将查询到的数据写入到ES
        for (int i = 0; i < productVOS.size(); i++) {
            ProductVO productVO = productVOS.get(i);

            String productId = productVO.getProductId();
            String productName = productVO.getProductName();
            Integer soldNum = productVO.getSoldNum();
            List<ProductSku> skus = productVO.getSkus();
            String skuName = skus.size()==0?"":skus.get(0).getSkuName();
            String skuImg = skus.size()==0?"":skus.get(0).getSkuImg();
            Integer sellPrice = skus.size()==0?0:skus.get(0).getSellPrice();

            ProductEs product = new ProductEs(productId, productName, skuImg, soldNum, skuName, sellPrice);

            //向ES中添加数据
            IndexRequest request = new IndexRequest("fmmallproductsindex");
            request.id(productId);
            request.source(objectMapper.writeValueAsString(product), XContentType.JSON);
            IndexResponse indexResponse = restHighLevelClient.index(request, RequestOptions.DEFAULT);
            System.out.println(i+1+"---------------"+indexResponse);
        }
    }
}
