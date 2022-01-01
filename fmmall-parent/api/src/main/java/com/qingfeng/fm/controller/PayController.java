package com.qingfeng.fm.controller;

import com.github.wxpay.sdk.WXPayUtil;
import com.qingfeng.fm.service.OrderService;
import com.qingfeng.fm.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/12/25
 */
@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    /**
     * 微信支付成功之后的操作
     *
     * 回调接口：当用户支付完成之后，微信支付平台就会请求这个接口，将支付状态的数据传递过来。
     */
    @RequestMapping("/callback")
    public String paySuccess(HttpServletRequest request) throws Exception {
        System.out.println("----------访问了-----------");

        //1、接收微信支付平台传递的数据（使用request的输入流接收）
        ServletInputStream inputStream = request.getInputStream();
        byte[] bs = new byte[2014];
        int len = -1;
        StringBuilder builder = new StringBuilder();
        while((len = inputStream.read(bs)) != -1){
            builder.append(new String(bs,0,len));
        }
        String s = builder.toString();

        //使用帮助类将xml接口的字符串换成map
        Map<String, String> map = WXPayUtil.xmlToMap(s);

        if (map != null && "success".equalsIgnoreCase(map.get("result_code"))){
            //支付成功
            //2、修改订单状态“待发货/已发货”
            String orderId = map.get("out_trade_no");
            int i = orderService.updateOrderStatus(orderId, "2");

            //3、通过websocket连接，向前端推送消息
            WebSocketServer.sendMsg(orderId,"1");

            //4、响应微信支付平台
            HashMap<String, String> resp = new HashMap<>();
            resp.put("return_code","success");
            resp.put("return_msg","OK");
            resp.put("app_id",map.get("appid"));
            resp.put("result_code","success");

            return WXPayUtil.mapToXml(resp);
        }

        //只要没有支付成功，都返回null
        return null;

    }
}
