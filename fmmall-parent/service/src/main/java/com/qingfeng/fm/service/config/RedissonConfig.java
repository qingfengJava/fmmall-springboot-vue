package com.qingfeng.fm.service.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/1/28
 */
@Configuration
public class RedissonConfig {

    @Value("${redisson.addr.singleAddr.host}")
    private String host;

    @Value("${redisson.addr.singleAddr.password}")
    private String password;

    @Value("${redisson.addr.singleAddr.database}")
    private int database;

    @Bean
    public RedissonClient getRdissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress(host).setPassword(password).setDatabase(database);
        return Redisson.create(config);
    }
}
