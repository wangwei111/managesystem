/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of  wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
        "com.wwmust.manage.system.starter",
        "com.wwmust.manage.system.dao.*"
})
@Component("com.wwmust.manage.system.service.user.impl")
@MapperScan("com.wwmust.manage.system.dao")
public class ManageSystemSpringBootApplication {
        public static void main(String[] args) {
            SpringApplication.run(ManageSystemSpringBootApplication.class, args);
        }
    }
