/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.starter.interceptor;

import com.wwmust.manage.system.config.redis.RedisKitWithSpringRedisTemplate;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 11/23/2019 0:30
 */
@Component
public class LoginInterceptor implements HandlerInterceptor  {

    private  static  final Logger log =  LoggerFactory.getLogger(LoginInterceptor.class.getSimpleName());

    @Autowired
    private RedisKitWithSpringRedisTemplate redisKitWithSpringRedisTemplate;

    private static final String SIGN= "sign";
    private static final String TIMESTAMP ="timestamp";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if(cookies ==null ){
            return  true;
        }
        for(Cookie cookie:cookies){
            if("token".equalsIgnoreCase(cookie.getName())){
                String value = cookie.getValue();
                if(StringUtils.isNotEmpty(value)){
                    Object obj = redisKitWithSpringRedisTemplate.get(value);
                    if(obj ==null){
                        //token无效请重新登录
                        request.getRequestDispatcher("/user/login").forward(request, response);
                        return false;
                    }else{
                        //更新token时间
                        redisKitWithSpringRedisTemplate.set(value,obj,30L, TimeUnit.MINUTES);
                        return  true;
                    }
                }
            }
        }
      return  true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception{
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }


}
