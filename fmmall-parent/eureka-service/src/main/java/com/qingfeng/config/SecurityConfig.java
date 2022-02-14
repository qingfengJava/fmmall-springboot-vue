package com.qingfeng.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/13
 */
@Configuration
@EnableMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //设置当前服务的所有请求都要使用spring security的认证
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}
