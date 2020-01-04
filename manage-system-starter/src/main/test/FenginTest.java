/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/

import com.wwmust.manage.system.service.config.RedisKit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 12/07/2019 19:21
 */
public class FenginTest {


    @Resource
    private RedisKit redisTemplate;

    @Autowired
    private ApplicationContext context;

    @Test
    public void a(){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for(int i=0;i<beanDefinitionNames.length;i++){
            System.out.println(beanDefinitionNames[i]);
        }
    }
}
