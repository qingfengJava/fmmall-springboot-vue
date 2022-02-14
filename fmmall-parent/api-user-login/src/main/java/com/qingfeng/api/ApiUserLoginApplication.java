package com.qingfeng.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;

/**
 * @author 清风学Java
 */
@SpringBootApplication
@EnableDiscoveryClient
@FeignClient
@EnableHystrix
public class ApiUserLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiUserLoginApplication.class, args);
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
}
