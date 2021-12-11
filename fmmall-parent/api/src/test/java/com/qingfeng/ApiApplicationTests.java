package com.qingfeng;

import com.qingfeng.fm.ApiApplication;
import com.qingfeng.fm.dao.CategoryMapper;
import com.qingfeng.fm.dao.ProductMapper;
import com.qingfeng.fm.entity.CategoryVO;
import com.qingfeng.fm.entity.ProductVO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
class ApiApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    void contextLoads() {
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories2(0);
        for (CategoryVO c1 : categoryVOS) {
            //一级目录
            System.out.println(c1);
            //二级目录
            for (CategoryVO c2 : c1.getCategories()) {
                System.out.println("\t"+c2);
                //三级目录
                for (CategoryVO c3 : c2.getCategories()) {
                    System.out.println("\t\t"+c3);
                }
            }
        }
    }

    @Test
    public void testRecommand(){
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();
        for (ProductVO productVO : productVOS) {
            System.out.println(productVO);
        }
    }

    @Test
    public void testSelectFirstLevelCategory(){
        List<CategoryVO> categoryVOS = categoryMapper.selectFirstLevelCategories();
        for (CategoryVO categoryVO : categoryVOS) {
            System.out.println(categoryVO);
        }
    }

}
