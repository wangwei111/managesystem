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
import com.wwmust.manage.system.facade.UserFacade;
import com.wwmust.manage.system.facade.resp.AdminResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 11/16/2019 20:04
 */
@RestController
public class TestController {

    @Autowired
    private UserFacade userFacade;

    @GetMapping("manage/api/test")
    public String test(){
        return "测试地址！";
    }

    @GetMapping("manage/api/getUser")
    public String getUser(){
        AdminResp admin=  userFacade.getUser();
        return JSON.toJSONString(admin);
    }
}
