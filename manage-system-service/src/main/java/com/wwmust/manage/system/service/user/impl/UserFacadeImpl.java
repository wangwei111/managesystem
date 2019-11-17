/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.service.user.impl;

import com.wwmust.manage.system.dao.UserMpper;
import com.wwmust.manage.system.facade.UserFacade;
import com.wwmust.manage.system.facade.resp.AdminResp;
import com.wwmust.manage.system.model.Admin;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 11/17/2019 21:20
 */
@Service("UserFacade")
@Component
public class UserFacadeImpl implements UserFacade {

    @Resource
    private UserMpper userMpper;
    @Override
    public AdminResp getUser() {
        AdminResp adminResp = new AdminResp();
        Admin admin =  userMpper.getUser();
        BeanUtils.copyProperties(admin,adminResp);
        return adminResp;
    }
}
