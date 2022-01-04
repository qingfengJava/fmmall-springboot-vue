package com.qingfeng.fm.service.impl;

import com.qingfeng.fm.dao.OrderItemMapper;
import com.qingfeng.fm.dao.OrdersMapper;
import com.qingfeng.fm.dao.ProductSkuMapper;
import com.qingfeng.fm.dao.ShoppingCartMapper;
import com.qingfeng.fm.entity.OrderItem;
import com.qingfeng.fm.entity.Orders;
import com.qingfeng.fm.entity.ProductSku;
import com.qingfeng.fm.entity.ShoppingCartVO;
import com.qingfeng.fm.service.OrderService;
import com.qingfeng.fm.vo.ResStatus;
import com.qingfeng.fm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.*;

/**
 * 订单的业务层接口实现
 *
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/12/24
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private ProductSkuMapper productSkuMapper;

    /**
     * 保存订单业务
     *
     * @param cids
     * @param orders
     * @return
     */
    @Transactional
    @Override
    public Map<String, String> addOrder(String cids, Orders orders) {
        Map<String, String> map = new HashMap<String, String>();

        //1、根据cids查询当前订单中关联的购物车记录详情（包括库存）
        String[] arr = cids.split(",");
        List<Integer> cidsList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            cidsList.add(Integer.parseInt(arr[i]));
        }
        List<ShoppingCartVO> list = shoppingCartMapper.selectShopCartByCids(cidsList);

        //2、校验库存
        boolean f = true;
        String untitled = "";
        for (ShoppingCartVO sc : list) {
            if (Integer.parseInt(sc.getCartNum()) > sc.getSkuStock()) {
                f = false;
            }
            //获取所有商品的名称，以逗号拼接成字符串
            untitled = untitled + sc.getProductName() + ",";
        }

        if (f) {
            //3、表示库存充足----保存订单
            //a.userId   b.untitled  c.收货人信息：姓名、电话、地址
            //d.总价格   e.支付方式   f.订单的创建时间  g.订单初始状态
            orders.setUntitled(untitled);
            orders.setCreateTime(new Date());
            orders.setStatus("1");

            //生成订单编号
            String orderId = UUID.randomUUID().toString().replace("-", "");
            orders.setOrderId(orderId);

            //保存订单
            int i = ordersMapper.insert(orders);
            //4、生成商品快照
            for (ShoppingCartVO sc : list) {
                int cnum = Integer.parseInt(sc.getCartNum());
                String itemId = System.currentTimeMillis() + "" + (new Random().nextInt(89999) + 10000);
                OrderItem orderItem = new OrderItem(itemId, orderId, sc.getProductId(), sc.getProductName(), sc.getProductImg(), sc.getSkuId(),
                        sc.getSkuName(), new BigDecimal(sc.getSellPrice()), cnum, new BigDecimal(sc.getSellPrice() * cnum), new Date(), new Date(), 0);
                orderItemMapper.insert(orderItem);
            }

            //5、扣减库存：根据套餐Id修改套餐库存量
            for (ShoppingCartVO sc : list) {
                String skuId = sc.getSkuId();
                int newStock = sc.getSkuStock() - Integer.parseInt(sc.getCartNum());

                ProductSku productSku = new ProductSku();
                productSku.setSkuId(skuId);
                productSku.setStock(newStock);
                //根据主键来修改属性值
                int k = productSkuMapper.updateByPrimaryKeySelective(productSku);
            }

            //6、删除购物车：当购物车中的记录购买成功之后，购物车中对应做删除操作
            for (int cid : cidsList) {
                shoppingCartMapper.deleteByPrimaryKey(cid);
            }

            map.put("orderId",orderId);
            map.put("productNames",untitled);
            return map;
        } else {
            //表示库存不足
            return null;
        }
    }

    @Override
    public int updateOrderStatus(String orderId, String status) {
        Orders orders = new Orders();
        orders.setOrderId(orderId);
        orders.setStatus(status);

        int i = ordersMapper.updateByPrimaryKeySelective(orders);
        return i;
    }

    @Override
    public ResultVO getOrderById(String orderId) {
        Orders order = ordersMapper.selectByPrimaryKey(orderId);

        return new ResultVO(ResStatus.OK,"success",order.getStatus());
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public void closeOrder(String orderId) {
        synchronized (this) {
            //  1、修改当前订单：status=6 已关闭  close_type=1 超时未支付
            Orders cancleOrder = new Orders();
            cancleOrder.setOrderId(orderId);
            //  已关闭
            cancleOrder.setStatus("6");
            //  关闭类型：超时未支付
            cancleOrder.setCloseType(1);
            ordersMapper.updateByPrimaryKeySelective(cancleOrder);
            //  2、还原库存：先根据当前订单编号查询商品快照（skuid  buy_count）---> 修改product_sku
            Example example1 = new Example(OrderItem.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("orderId",orderId);
            List<OrderItem> orderItems = orderItemMapper.selectByExample(example1);
            //还原库存
            for (OrderItem orderItem : orderItems) {
                //修改
                ProductSku productSku = productSkuMapper.selectByPrimaryKey(orderItem.getOrderId());
                productSku.setStock(productSku.getStock()+orderItem.getBuyCounts());
                productSkuMapper.updateByPrimaryKey(productSku);
            }
        }
    }
}
