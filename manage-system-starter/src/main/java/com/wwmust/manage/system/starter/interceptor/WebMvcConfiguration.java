/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.starter.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 11/23/2019 11:21
 */



@SpringBootConfiguration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Value( "${login.interceptor.register}")
    private boolean loginInterceptorRegister;

    @Autowired
    private  LoginInterceptor loginInterceptor;

    @Override
    public  void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .maxAge(0);
    }


    @Override
    public  void addInterceptors(InterceptorRegistry registry){
        if(loginInterceptorRegister){
            registry.addInterceptor(loginInterceptor)
                    .addPathPatterns("/**")
                    .excludePathPatterns("/login","/task/**");
        }
    }
}
