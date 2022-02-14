package com.qingfeng;

import com.qingfeng.fm.ApiApplication;
import com.qingfeng.fm.dao.*;
import com.qingfeng.fm.entity.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
class ApiApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductCommentsMapper productCommentsMapper;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private OrdersMapper ordersMapper;

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

    @Test
    public void testSelectComments(){
        List<ProductCommentsVO> productCommentsVOS = productCommentsMapper.selectCommentsByProductId("3",1,2);
        for (ProductCommentsVO productCommentsVO : productCommentsVOS) {
            System.out.println(productCommentsVO);
        }
    }

    @Test
    public void testShopCart(){
        /*List<ShoppingCartVO> shoppingCartVOS = shoppingCartMapper.selectShopCartByUserId(1);
        System.out.println(shoppingCartVOS);*/

        /*List<Integer> cids = new ArrayList<>();
        cids.add(1);
        cids.add(8);
        cids.add(10);
        List<ShoppingCartVO> shoppingCartVOS = shoppingCartMapper.selectShopCartByCids(cids);
        System.out.println(shoppingCartVOS);*/

        String cids = "1,8";

        String[] arr = cids.split(",");
        List<Integer> cidsList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            cidsList.add(Integer.parseInt(arr[i]));
        }
        List<ShoppingCartVO> list = shoppingCartMapper.selectShopCartByCids(cidsList);
        for (ShoppingCartVO shoppingCartVO : list) {
            System.out.println(shoppingCartVO);
        }
    }

    @Test
    public void test(){
        //1、查询超过30min订单状态依然为待支付状态的订单
        Example example = new Example(Orders.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status","1");

        Date time = new Date(System.currentTimeMillis()-30*60*1000);
        //生成订单的时间比当前时间减去半个小时还小，说明是超时订单
        criteria.andLessThan("createTime",time);

        List<Orders> orders = ordersMapper.selectByExample(example);
        orders.forEach(order -> System.out.println(order.getOrderId()+"\t"+order.getCreateTime()+"\t"+order.getStatus()));
    }


}
