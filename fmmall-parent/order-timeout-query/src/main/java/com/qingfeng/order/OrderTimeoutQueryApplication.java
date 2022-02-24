package com.qingfeng.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 清风学Java
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.qingfeng.order.dao")
public class OrderTimeoutQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderTimeoutQueryApplication.class, args);
    }

}
