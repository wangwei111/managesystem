/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.facade;

import com.wwmust.manage.system.facade.param.LoginUserParam;
import com.wwmust.manage.system.facade.param.RegisterUserParam;
import com.wwmust.manage.system.facade.resp.AdminResp;
import com.wwmust.manage.system.facade.resp.UserInfoResp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 11/17/2019 21:16
 */
public interface UserFacade {

    /**
     * 用户登录
     * @param loginUserParam
     */
    UserInfoResp userLogin(LoginUserParam loginUserParam) throws Exception;

    /**
     * 根据token查询用户信息
     * @param response
     * @param request
     * @return
     */
    UserInfoResp getUserInfo(HttpServletResponse response, HttpServletRequest request);

    /**
     * 注册用户信息
     * @param registerUserParam
     * @return
     */
    UserInfoResp register(RegisterUserParam registerUserParam) throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
