package com.qingfeng.api.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/3/17
 */
@Service
public class SendMsgToMq {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMsg(String orderId){
        amqpTemplate.convertAndSend("ex6","key1",orderId);
    }
}
