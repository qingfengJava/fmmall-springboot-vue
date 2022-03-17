package com.qingfeng.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 清风学Java
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableScheduling
public class OrderTimeoutCancleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderTimeoutCancleApplication.class, args);
    }

}
