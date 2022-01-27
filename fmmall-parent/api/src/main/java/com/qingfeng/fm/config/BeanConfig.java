package com.qingfeng.fm.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/1/26
 */
@Configuration
public class BeanConfig {

    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
}
