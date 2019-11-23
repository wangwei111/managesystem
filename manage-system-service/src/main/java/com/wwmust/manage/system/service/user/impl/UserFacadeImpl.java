/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.service.user.impl;

import com.wwmust.manage.system.common.exception.DataInvalidataException;
import com.wwmust.manage.system.config.SnowflakeWorker;
import com.wwmust.manage.system.config.redis.RedisKitWithSpringRedisTemplate;
import com.wwmust.manage.system.dao.UserMpper;
import com.wwmust.manage.system.facade.UserFacade;
import com.wwmust.manage.system.facade.param.LoginUserParam;
import com.wwmust.manage.system.facade.param.RegisterUserParam;
import com.wwmust.manage.system.facade.resp.AdminResp;
import com.wwmust.manage.system.facade.resp.UserInfoResp;
import com.wwmust.manage.system.model.User;
import com.wwmust.manage.system.service.units.Md5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 11/17/2019 21:20
 */
@Service("UserFacade")
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserMpper userMpper;


    @Autowired
    private RedisKitWithSpringRedisTemplate redisKitWithSpringRedisTemplate;



    /**
     * 用户登录
     * @param loginUserParam
     */
    @Override
    public UserInfoResp userLogin(LoginUserParam loginUserParam) throws Exception {
        Assert.isNull(loginUserParam.getUsername(),"用户名不能为空！");
        Assert.isNull(loginUserParam.getPassword(),"密码不能为空！");
        User user = userMpper.chickUserName(loginUserParam.getUsername());
        UserInfoResp userInfoResp = new UserInfoResp();
        if(user !=null){
            boolean verify = Md5Util.checkpassword(loginUserParam.getPassword(),  user.getPassword());
            if(verify){
                //生成token
                String token=user.getUsername()+loginUserParam.getPassword()+System.currentTimeMillis();
                //存在redis中
                redisKitWithSpringRedisTemplate.setIfAbsent(Md5Util.EncoderByMd5(token),user,30, TimeUnit.MINUTES);
                userInfoResp.setToken(token);
                BeanUtils.copyProperties(user,userInfoResp);
            }else{
                throw    new DataInvalidataException("你输入的密码错误,请从新输入！");
            }
        }else {
          throw   new DataInvalidataException("您的账号不存在！");
        }
        return  userInfoResp;
    }

    @Override
    public UserInfoResp getUserInfo(HttpServletResponse response, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie :cookies){
            if(cookie.getName().equalsIgnoreCase("token")){
                String value = cookie.getValue();
                UserInfoResp userInfoResp = redisKitWithSpringRedisTemplate.get(value);
                return userInfoResp;
            }
        }
        return null;
    }

    @Override
    public UserInfoResp register(RegisterUserParam registerUserParam) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Assert.isTrue(!StringUtils.isEmpty(registerUserParam.getUsername()),"用户名不能为空！");
        Assert.isTrue(!StringUtils.isEmpty(registerUserParam.getPassword()),"密码不能为空！");
        User user = userMpper.chickUserName(registerUserParam.getUsername());
        UserInfoResp userInfoResp = new UserInfoResp();
        if(user == null){
            user =new User();
            //加密
            String password = Md5Util.EncoderByMd5(registerUserParam.getPassword());
            registerUserParam.setPassword(password);
            registerUserParam.setIsValid("1");//有效
            registerUserParam.setCaretaDate(new Date());
            registerUserParam.setUid(SnowflakeWorker.generateId());
            registerUserParam.setUpdateDate(new Date());
            registerUserParam.setAccountNumber(registerUserParam.getUsername());
            BeanUtils.copyProperties(registerUserParam,user);
            userMpper.insert(user);
            BeanUtils.copyProperties(user,userInfoResp);
        }else{
            throw   new DataInvalidataException("该账号已经被注册！");
        }
            return userInfoResp;
    }
}
