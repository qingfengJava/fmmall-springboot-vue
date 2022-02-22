package com.qingfeng.shopcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 清风学Java
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.qingfeng.shopcart.dao")
public class ShopcartDelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopcartDelApplication.class, args);
    }

}
