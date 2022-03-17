package com.qingfeng.order.service;

import com.github.wxpay.sdk.WXPay;
import com.qingfeng.fm.beans.Orders;
import com.qingfeng.order.config.MyPayConfig;
import com.qingfeng.order.feign.OrderCloseClient;
import com.qingfeng.order.feign.OrderStatusUpdateClient;
import com.qingfeng.order.feign.OrderTimeoutQueryClient;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/3/17
 */
@Service
@RabbitListener(queues = "q2")
public class ReceiveMsgFromMqService {

    @Autowired
    private OrderTimeoutQueryClient orderTimeoutQueryClient;
    private WXPay wxPay = new WXPay(new MyPayConfig());
    @Autowired
    private OrderStatusUpdateClient orderStatusUpdateClient;
    @Autowired
    private OrderCloseClient orderCloseClient;

    @RabbitHandler
    public void checkAndCancelOrder(String orderId, Channel channel, Message message) throws IOException {
        //1、查询超时的订单
        try {
            //1、根据订单编号查询当前订单信息
            //伪代码
            Orders order = null;
            if ("1".equals(order.getStatus())){
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
            }else{
                //手动ACK应答
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,true);

        }
    }
}
