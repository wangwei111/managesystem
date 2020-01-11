/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.starter.controller;

import com.wwmust.manage.system.config.response.JsonResult;
import com.wwmust.manage.system.facade.UserFacade;
import com.wwmust.manage.system.facade.param.LoginUserParam;
import com.wwmust.manage.system.facade.param.RegisterUserParam;
import com.wwmust.manage.system.facade.resp.UserInfoResp;
import com.wwmust.manage.system.starter.util.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ${DESCRIPTION}
 * 用户
 * @author wangwei<wwfdqc@126.com>
 * @date 11/23/2019 12:50
 */
@RestController
public class UserController {

    private  static  final Logger log =  LoggerFactory.getLogger(UserController.class.getSimpleName());



    @Autowired
    private UserFacade userFacade;

    /**
     * 登录
     * @param loginUserParam
     * @return
     */
    @PostMapping("/api/system/user/login")
    public JsonResult userLogin(@RequestBody  LoginUserParam loginUserParam,HttpServletResponse response, HttpServletRequest request){
        try{
            UserInfoResp userInfoResp = userFacade.userLogin(loginUserParam);
          /*  if(userInfoResp !=null){
                Cookie cookie=new Cookie("token", userInfoResp.getToken());
                cookie.setMaxAge(30000); //存活期为30分钟
                response.addCookie(cookie);
            }*/
            return JsonResult.okJsonResultWithData(userInfoResp);
        }catch (Exception e){
            log.error("api/system/user/login:error:{}"+e);
            return  JsonResult.failJsonResult(e.getMessage());
        }
    }


    @PostMapping("/api/system/user/register")
    public JsonResult register(@RequestBody  RegisterUserParam registerUserParam, HttpServletResponse response, HttpServletRequest request){
        try{
            UserInfoResp userInfoResp = userFacade.register(registerUserParam);
            return JsonResult.okJsonResultWithData(userInfoResp);
        }catch (Exception e){
            log.error("api/system/user/register:error:{}"+e);
            return  JsonResult.failJsonResult(e.getMessage());
        }
    }


    /**
     * 查询用户信息
     * @return
     */
    @GetMapping("/api/user/userinfo")
    public JsonResult getUserInfo(HttpServletResponse response, HttpServletRequest request){
        try{
            String userId = UserContext.getUserId(request);
            UserInfoResp userInfoResp = userFacade.getUserInfo(userId);
            return JsonResult.okJsonResultWithData(userInfoResp);
        }catch (Exception e){
            log.error("api/system/user/getUserInfo:error：{}"+e);
            return  JsonResult.failJsonResult(e.getMessage());
        }
    }


    @PostMapping("/api/user/loginauthcode")
    public JsonResult loginauthcode(String phone, String authcode, HttpServletResponse response, HttpServletRequest request) {
        try {
            String userId = UserContext.getUserId(request);
            UserInfoResp userInfoResp = userFacade.loginauthcode(phone, authcode);
            return JsonResult.okJsonResultWithData(userInfoResp);
        } catch (Exception e) {
            log.error("api/system/user/register:error:{}" + e);
            return JsonResult.failJsonResult(e.getMessage());
        }
    }


    @PostMapping("/api/user/register")
    public JsonResult setpassword(@RequestBody RegisterUserParam registerUserParam, HttpServletResponse response, HttpServletRequest request) {
        try {
            String userId = UserContext.getUserId(request);
            if (StringUtils.isEmpty(userId)) {
                return null;
            } else {
                registerUserParam.setUid(Long.parseLong(userId));
            }
            UserInfoResp userInfoResp = userFacade.register(registerUserParam);
            return JsonResult.okJsonResultWithData(userInfoResp);
        } catch (Exception e) {
            log.error("api/system/user/register:error:{}" + e);
            return JsonResult.failJsonResult(e.getMessage());
        }
    }


}
