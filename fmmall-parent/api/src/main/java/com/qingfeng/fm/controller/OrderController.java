package com.qingfeng.fm.controller;

import com.github.wxpay.sdk.WXPay;
import com.qingfeng.fm.entity.Orders;
import com.qingfeng.fm.service.OrderService;
import com.qingfeng.fm.service.job.MyPayConfig;
import com.qingfeng.fm.vo.ResStatus;
import com.qingfeng.fm.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/12/24
 */
@RestController
@CrossOrigin
@RequestMapping("/order")
@Api(value = "提供订单相关的操作接口",tags = "订单管理")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation("添加订单支付接口")
    @PostMapping("/add")
    public ResultVO add(String cids,@RequestBody Orders order){
        ResultVO resultVO = null;
        try {
            Map<String, String> orderInfo = orderService.addOrder(cids, order);
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
                data.put("notify_url","http://ytao01.free.idcfengye.com/pay/callback");

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

    @ApiOperation("查询订单状态并返回")
    @GetMapping("/status/{oid}")
    public ResultVO getOrderStatus(@PathVariable("oid") String orderId,@RequestHeader("token") String token){
        ResultVO resultVO = orderService.getOrderById(orderId);
        return resultVO;
    }

    @ApiOperation("根据用户Id查询订单信息返回")
    @GetMapping("/list")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "string",name = "userId",value = "用户Id",required = true),
            @ApiImplicitParam(paramType = "string",name = "status",value = "订单状态",required = true),
            @ApiImplicitParam(paramType = "int",name = "pageNum",value = "页码",required = true),
            @ApiImplicitParam(paramType = "int",name = "limit",value = "每页条数",required = true)
    })
    public ResultVO list(@RequestHeader("token") String token,
                         String userId,String status,int pageNum,int limit){
        ResultVO resultVO = orderService.listOrder(userId, status, pageNum, limit);
        return resultVO;
    }
}
