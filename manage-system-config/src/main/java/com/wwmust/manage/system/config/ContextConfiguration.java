/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of bytedance EA project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * ${DESCRIPTION}
 *
 * @author 37079<37079@wwmust.com>
 * @date 12/22/2019 14:55
 */
@Configuration
public class ContextConfiguration {


    @Bean
    PageHelper pageHelper() {
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        //添加插件
        new SqlSessionFactoryBean().setPlugins(new Interceptor[]{pageHelper});
        return pageHelper;
    }
}