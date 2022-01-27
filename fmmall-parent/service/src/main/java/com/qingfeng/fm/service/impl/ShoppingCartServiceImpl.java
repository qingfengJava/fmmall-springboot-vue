package com.qingfeng.fm.service.impl;

import com.qingfeng.fm.dao.ShoppingCartMapper;
import com.qingfeng.fm.entity.ShoppingCart;
import com.qingfeng.fm.entity.ShoppingCartVO;
import com.qingfeng.fm.service.ShoppingCartService;
import com.qingfeng.fm.vo.ResStatus;
import com.qingfeng.fm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/12/17
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public ResultVO addShoppingCart(ShoppingCart cart) {




        cart.setCartTime(sdf.format(new Date()));
        int i = shoppingCartMapper.insert(cart);
        if (i > 0){
            //添加成功
            return new ResultVO(ResStatus.OK,"success",null);
        }else{
            return new ResultVO(ResStatus.NO,"fail",null);
        }
    }

    @Override
    public ResultVO listShoppingCartByUserId(int userId) {
        List<ShoppingCartVO> list = shoppingCartMapper.selectShopCartByUserId(userId);
        ResultVO resultVO = new ResultVO(ResStatus.OK,"success",list);
        return resultVO;
    }

    @Override
    public ResultVO updateCartNum(int cartId, int cartNum) {
        int i = shoppingCartMapper.updateCartNumByCartId(cartId, cartNum);
        if (i > 0){
            //表示成功
            return new ResultVO(ResStatus.OK,"update success",null);
        }else{
            //失败
            return new ResultVO(ResStatus.NO,"update fail",null);
        }
    }

    @Override
    public ResultVO deleteByCartId(int cartId) {
        int i = shoppingCartMapper.deleteByCartId(cartId);
        if (i > 0){
            //表示删除成功
            return new ResultVO(ResStatus.OK,"delete success",null);
        }else{
            //删除失败
            return new ResultVO(ResStatus.OK,"delete fail",null);
        }
    }

    @Override
    public ResultVO listShoppingCartsByCids(String cids) {
        //注意：使用tkmapper只能查询到某张表中拥有的字段，因此没法查询到商品名称、图片、单价等信息
        String[] arr = cids.split(",");
        List<Integer> cartIds = new ArrayList<>();
        for (String s : arr) {
            cartIds.add(Integer.parseInt(s));
        }
        List<ShoppingCartVO> list = shoppingCartMapper.selectShopCartByCids(cartIds);
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", list);

        return resultVO;
    }
}
