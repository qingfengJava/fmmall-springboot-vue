package com.qingfeng.api.controller;

import com.github.wxpay.sdk.WXPay;
import com.qingfeng.api.config.MyPayConfig;
import com.qingfeng.api.service.OrderSubmitService;
import com.qingfeng.fm.beans.Orders;
import com.qingfeng.fm.vo.ResStatus;
import com.qingfeng.fm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/22
 */
@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderSubmitController {

    @Autowired
    private OrderSubmitService orderSubmitService;

    @PostMapping("/add")
    public ResultVO add(String cids, @RequestBody Orders order){
        ResultVO resultVO = null;
        try {
            Map<String, String> orderInfo = orderSubmitService.addOrder(cids, order);
            String orderId = orderInfo.get("orderId");

            if(orderId != null){
                //设置当前订单的信息
                HashMap<String, String> data = new HashMap<>();
                //商品描述
                data.put("body",orderInfo.get("productNames"));
                //使用当前用户订单的编号作为当前支付交易的交易号
                data.put("out_trade_no",orderId);
                //设置支付的币种  人民币
                data.put("fee_type","CNY");
                //设置支付的总金额  1分钱
                data.put("total_fee",order.getActualAmount()*100+"");
                //交易类型
                data.put("trade_type","NATIVE");
                //设置支付完成时的回调方法接口
                data.put("notify_url","http://47.108.28.239:8080/pay/callback");

                //订单保存成功：微信支付：申请支付链接
                WXPay wxPay = new WXPay(new MyPayConfig());

                //发送请求，获取响应，拿到支付链接
                Map<String, String> resp = wxPay.unifiedOrder(data);
                /*orderInfo.put("payUrl",resp.get("code_url"));*/
                orderInfo.put("payUrl","https://gitee.com/pjlwlcxy/projects");
                resultVO = new ResultVO(ResStatus.OK,"提交订单成功！",orderInfo);

            }else{
                resultVO = new ResultVO(ResStatus.NO,"提交订单失败！",null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            resultVO = new ResultVO(ResStatus.NO,"提交订单失败！",null);
        }
        return resultVO;
    }
}
