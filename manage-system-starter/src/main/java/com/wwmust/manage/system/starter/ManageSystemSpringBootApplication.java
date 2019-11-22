/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of  wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.starter;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 *
 * @author 37079<37079@wwmust.com>
 * @date 11/11/2019 20:39
 */
@SpringBootApplication(scanBasePackages = {
        "com.wwmust.manage.system.service",
        "com.wwmust.manage.system.starter"
})
@MapperScan(basePackages = {
        "com.wwmust.manage.system.dao"
})
@Slf4j
public class ManageSystemSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ManageSystemSpringBootApplication.class);
        Environment env = app.run(args).getEnvironment();
        log.info("\n----------------------------------------------------------\n\t" +
                        "服务端 '{}' 启动成功!" +
                        "\n\t环境: \t{}" +
                        "\n\t访问地址: \thttp://127.0.0.1:{}" +
                        "\n\t接口文档: \thttp://127.0.0.1:{}/swagger-ui.html" +
                        "\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getActiveProfiles(),
                env.getProperty("server.port"),
                env.getProperty("server.port")
        );
    }
}
