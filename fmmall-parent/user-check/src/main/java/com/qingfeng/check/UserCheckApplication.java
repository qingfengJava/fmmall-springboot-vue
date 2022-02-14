package com.qingfeng.check;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 清风学Java
 */
@SpringBootApplication
@MapperScan("com.qingfeng.check.dao")
public class UserCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCheckApplication.class, args);
    }

}
