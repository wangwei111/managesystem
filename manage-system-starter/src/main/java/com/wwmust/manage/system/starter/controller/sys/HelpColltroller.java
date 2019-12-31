/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.starter.controller.sys;

import com.wwmust.manage.system.config.response.JsonResult;
import com.wwmust.manage.system.facade.param.article.ArticleQueryParam;
import com.wwmust.manage.system.facade.resp.article.ArticleResp;
import com.wwmust.manage.system.service.sys.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 12/31/2019 8:18
 */
@RestController
public class HelpColltroller {


    @Autowired
    private HelpService helpService;

    /**
     * 帮助
     * @return
     */
    @PostMapping("api/article/help")
    public JsonResult help(HttpServletResponse response, HttpServletRequest request,String message){
        try {
            helpService.save(message);
            return JsonResult.okJsonResultWithData( null);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.failJsonResultWithData(null);
        }
    }
}
