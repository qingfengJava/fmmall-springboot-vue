package com.qingfeng.orderitem;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 清风学Java
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDistributedTransaction
@MapperScan("com.qingfeng.orderitem.dao")
public class OrderitemAddApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderitemAddApplication.class, args);
    }

}
