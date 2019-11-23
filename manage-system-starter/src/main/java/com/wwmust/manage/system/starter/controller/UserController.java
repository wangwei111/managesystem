/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.starter.controller;

import com.alibaba.fastjson.JSON;
import com.wwmust.manage.system.config.response.JsonResult;
import com.wwmust.manage.system.facade.UserFacade;
import com.wwmust.manage.system.facade.param.LoginUserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 * 用户
 * @author wangwei<wwfdqc@126.com>
 * @date 11/23/2019 12:50
 */
@RestController
public class UserController {

    @Autowired
    private UserFacade userFacade;

    public JsonResult userLogin(LoginUserParam loginUserParam){
        try{
            userFacade.userLogin(loginUserParam);
            return JsonResult.okJsonResultWithMsg("登录成功");
        }catch (Exception e){
            return  JsonResult.failJsonResult(e.getMessage());
        }
    }
}
