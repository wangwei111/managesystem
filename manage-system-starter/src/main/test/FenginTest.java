/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/

import com.alibaba.fastjson.JSON;
import com.wwmust.manage.system.config.RedisKitWithSpringRedisTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 12/07/2019 19:21
 */
public class FenginTest {


    @Autowired
    private RedisKitWithSpringRedisTemplate redisTemplate;

    @Test
    public void a(){

        Object o = redisTemplate.get("123");
System.out.println(o);
    }
}
