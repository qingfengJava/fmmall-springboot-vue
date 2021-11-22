package com.qingfeng.fm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger的配置类，因为SpringBoot应用没有默认集成swagger，所以需要配置
 *
 * swagger是一个用于生成服务器接口的规范性文档，并且能够对接口进行测试的工具。
 *
 * 为什么要配置？
 * swagger会帮助我们生成接口文档、
 * 1：配置生成的文档信息
 * 2：配置生成规则
 *
 * @author 清风学Java
 * @date 2021/11/5
 * @apiNote
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Docket封装接口文档信息
     *
     * @return
     */
    @Bean
    public Docket getDocket() {

        /*
        复习：如何获取一个接口/抽象类对象
        1、new接口，需要在构造器后的{}实现接口中的所有抽象方法
        2、new 子类/实现类
        3、工厂模式
         */
        //定义创建封面信息对象
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        //设置文档标题     支持链式调用
        apiInfoBuilder.title("《锋迷商城》后端接口说明")
                //描述信息
                .description("此文档详细说明了锋迷商城项目后端接口规范...")
                //版本
                .version("v 2.0.1")
                //联系人
                .contact(new Contact("清风学Java","www.qingfeng.com","qingfeng@qq.com"));
        ApiInfo apiInfo= apiInfoBuilder.build();

        //参数指定文档风格(生成策略)
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                //指定生成的文档中的封面信息：文档标题、版本、作者
                .apiInfo(apiInfo)
                .select()
                //对那个类生成api文档
                .apis(RequestHandlerSelectors.basePackage("com.qingfeng.fm.controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }
}
