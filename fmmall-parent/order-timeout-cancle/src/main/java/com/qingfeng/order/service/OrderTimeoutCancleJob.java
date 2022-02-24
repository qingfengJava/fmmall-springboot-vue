package com.qingfeng.order.service;

import com.github.wxpay.sdk.WXPay;
import com.qingfeng.fm.beans.Orders;
import com.qingfeng.order.config.MyPayConfig;
import com.qingfeng.order.feign.OrderCloseClient;
import com.qingfeng.order.feign.OrderStatusUpdateClient;
import com.qingfeng.order.feign.OrderTimeoutQueryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/24
 */
@Component
public class OrderTimeoutCancleJob {

    @Autowired
    private OrderTimeoutQueryClient orderTimeoutQueryClient;
    private WXPay wxPay = new WXPay(new MyPayConfig());
    @Autowired
    private OrderStatusUpdateClient orderStatusUpdateClient;
    @Autowired
    private OrderCloseClient orderCloseClient;

    //https://corn.qqe2.com
    @Scheduled(cron = "0/3 * * * * ?")
    public void checkAndCancelOrder(){
        //1、查询超时的订单
        try {
            //1、调用order-timeout-query  查询超过30min订单状态依然为待支付状态的订单
            List<Orders> orders = orderTimeoutQueryClient.query();

            //2、访问微信平台接口，确认当前订单最终的支付状态
            for (Orders order : orders) {
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("out_trade_no", order.getOrderId());
                Map<String, String> resp = wxPay.orderQuery(params);

                //判断订单是否支付
                if ("SUCCESS".equalsIgnoreCase(resp.get("trade_state"))) {
                    //2.1、如果订单已经支付，则修改订单状态为“代发货|已支付” status=2
                    Orders updateOrder = new Orders();
                    updateOrder.setOrderId(order.getOrderId());
                    updateOrder.setStatus("2");

                    //调用 order-status-update服务，修改订单状态为2
                    int j = orderStatusUpdateClient.update(updateOrder);

                } else if ("NOTPAY".equalsIgnoreCase(resp.get("trade_state"))) {
                    //2.2、如果确实未支付，则取消订单
                    //  a. 向微信支付平台发送请求，关闭当前订单的支付链接
                    Map<String, String> map = wxPay.closeOrder(params);

                    //  b. 关闭订单
                    int k = orderCloseClient.close(order.getOrderId(), 1);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
