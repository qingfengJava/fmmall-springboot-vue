package com.qingfeng.product.sku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 清风学Java
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.qingfeng.product.sku.dao")
public class ProductSkuQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductSkuQueryApplication.class, args);
    }

}
