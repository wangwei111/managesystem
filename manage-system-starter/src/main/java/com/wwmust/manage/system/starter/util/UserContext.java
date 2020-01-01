/**
 * *****************************************************
 * Copyright (C) 2020 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.starter.util;

import com.wwmust.manage.system.config.RedisKitWithSpringRedisTemplate;
import com.wwmust.manage.system.facade.UserFacade;
import com.wwmust.manage.system.facade.resp.UserInfoResp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


/**
 * ${DESCRIPTION}
 * 获取用户信息
 * @author wangwei<wwfdqc@126.com>
 * @date 01/01/2020 15:40
 */
public   class UserContext {

    @Autowired
    private RedisKitWithSpringRedisTemplate redisKit;

    @Autowired
    private static UserFacade userFacade;


    public  UserInfoResp getUser(HttpServletRequest request){
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            if(key.equalsIgnoreCase("token")){
                String userId = redisKit.get(request.getHeader(key));
                if(StringUtils.isNotEmpty(userId)){
                 UserInfoResp userInfoResp =     userFacade.getUserInfoByUserId(userId);
                }
            }
        }
        return null;
    }

    public  String getUserId(HttpServletRequest request){
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            if(key.equalsIgnoreCase("token")){
                String header = request.getHeader(key);
                String  userId = redisKit.get(header);
                return  userId;
            }
        }
        return null;
    }
}
