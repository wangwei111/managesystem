/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.service.user;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwmust.manage.system.common.exception.DataInvalidataException;
import com.wwmust.manage.system.config.SnowflakeWorker;
import com.wwmust.manage.system.dao.SysUserMapper;
import com.wwmust.manage.system.facade.UserFacade;
import com.wwmust.manage.system.facade.param.LoginUserParam;
import com.wwmust.manage.system.facade.param.RegisterUserParam;
import com.wwmust.manage.system.facade.resp.UserInfoResp;
import com.wwmust.manage.system.model.SysUser;
import com.wwmust.manage.system.service.config.RedisKit;
import com.wwmust.manage.system.service.units.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 11/17/2019 21:20
 */
@Service
public class UserFacadeImpl implements UserFacade {
    private  static  final Logger log =  LoggerFactory.getLogger(UserFacadeImpl.class.getSimpleName());

    @Autowired
    private SysUserMapper userMpper;


    @Autowired
    private RedisKit redisKit;



    /**
     * 用户登录
     * @param loginUserParam
     */
    @Override
    public UserInfoResp userLogin(LoginUserParam loginUserParam) throws Exception {
        Assert.isTrue(!StringUtils.isEmpty(loginUserParam.getUsername()),"用户名不能为空！");
        Assert.isTrue(!StringUtils.isEmpty(loginUserParam.getPassword()),"密码不能为空！");
        SysUser user = userMpper.chickUserName(loginUserParam.getUsername());
        UserInfoResp userInfoResp = new UserInfoResp();
        if(user !=null){
            //  boolean verify = Md5Util.checkpassword(loginUserParam.getPassword(),  user.getPassword());
            if (!StringUtils.isEmpty(user.getPassword()) && user.getPassword().equals(loginUserParam.getPassword())) {
                //生成token
                String token = user.getAccount() + loginUserParam.getPassword() + System.currentTimeMillis();
                //存在redis中
                redisKit.set(token,user.getUserId().toString(),30000L,TimeUnit.MINUTES);
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
    public UserInfoResp getUserInfo(String userId) {
        SysUser sysUser =   userMpper.getUserInfo(userId);
        if(sysUser != null ){
            UserInfoResp userInfoResp = new UserInfoResp();
            BeanUtils.copyProperties(sysUser,userInfoResp);
            userInfoResp.setUid(sysUser.getUserId());
            userInfoResp.setImgUrl(sysUser.getUserImg());
            userInfoResp.setUsername(sysUser.getNickname());
            userInfoResp.setIntroduce(sysUser.getSelfIntroduction());
            return   userInfoResp;
        }
        return null;
    }

    @Override
    public UserInfoResp register(RegisterUserParam registerUserParam) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        //    Assert.isTrue(!StringUtils.isEmpty(registerUserParam.getUsername()),"用户名不能为空！");
        Assert.isTrue(!StringUtils.isEmpty(registerUserParam.getPassword()),"密码不能为空！");
        userMpper.updatePasswordByUid(registerUserParam.getUid(), registerUserParam.getPassword());
        return null;
        /*SysUser user = userMpper.chickUserName(registerUserParam.getUsername());
        UserInfoResp userInfoResp = new UserInfoResp();
        if(user == null){
            user = new SysUser();
            //加密
            String password = Md5Util.EncoderByMd5(registerUserParam.getPassword());
            registerUserParam.setPassword(password);
            registerUserParam.setIsValid("1");//有效
            registerUserParam.setCaretaDate(new Date());
            registerUserParam.setUid(SnowflakeWorker.generateId());
            registerUserParam.setUpdateDate(new Date());
            registerUserParam.setAccountNumber(registerUserParam.getUsername());
            BeanUtils.copyProperties(registerUserParam,user);
            log.info(JSON.toJSONString(user));
            userMpper.insertSelective(user);
            BeanUtils.copyProperties(user,userInfoResp);
        }else{
            log.error("该账号已经被注册！");
            throw   new DataInvalidataException("该账号已经被注册！");
        }*/
        // return userInfoResp;
    }

    @Override
    public UserInfoResp getUserInfoByUserId(String userId) {
     //   userMpper.getUserInfoByUserId(userId);
        return null;
    }

    @Override
    public PageInfo<UserInfoResp> getMyFocusUser(String userId,Integer pageSize,Integer pageNum) {
        if (StringUtils.isEmpty(userId)) {
            return null;
        }
        if (pageSize ==null ||pageSize== 0) {
            pageSize =10;
        }
        if (pageNum== null ) {
            pageNum =0;
        }
        PageHelper.startPage(pageNum, pageSize);
       List<SysUser> sysUsers= userMpper.getMyFocusUser(userId);
       if(!CollectionUtils.isEmpty(sysUsers)){
        List<UserInfoResp> userInfoResps = new ArrayList<>();
        sysUsers.forEach(user->{
            UserInfoResp userInfoResp = new UserInfoResp();
            BeanUtils.copyProperties(user,userInfoResp);
            userInfoResp.setUsername(user.getNickname());
            userInfoResp.setImgUrl(user.getUserImg());
            userInfoResp.setUid(user.getUserId());
            userInfoResp.setIntroduce(user.getSelfIntroduction());
            userInfoResps.add(userInfoResp);
        });
           PageInfo<UserInfoResp> pageInfo = new PageInfo<>(userInfoResps);
           return  pageInfo;
       }
      return new PageInfo<>(null);
    }

    @Override
    public UserInfoResp loginauthcode(String phone, String authcode) {
        return null;
    }
}
