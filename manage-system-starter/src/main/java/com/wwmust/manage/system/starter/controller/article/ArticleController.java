/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.starter.controller.article;

import com.wwmust.manage.system.config.response.JsonResult;
import com.wwmust.manage.system.facade.ArticleFacade;
import com.wwmust.manage.system.facade.param.article.ArticleParam;
import com.wwmust.manage.system.facade.param.article.ArticleQueryParam;
import com.wwmust.manage.system.facade.resp.article.ArticleResp;
import com.wwmust.manage.system.facade.resp.article.ArticleSkinStypeResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *文章处理类
 * @author wangwei<wwfdqc@126.com>
 * @date 12/07/2019 15:15
 */
@RestController
public class ArticleController {


    @Autowired
    private ArticleFacade articleFacade;
    /**
     * 获取皮肤
     * @return
     */
    @GetMapping("api/article/getSkinType")
    public JsonResult<List<ArticleSkinStypeResp>> getSkinType(Long articleSkinTypeId){
        List<ArticleSkinStypeResp>  list = articleFacade.getSkinType(articleSkinTypeId);
        return JsonResult.okJsonResultWithData( list);
    }

    /**
     * 暂存及保存
     */
    @PostMapping("api/article/save")
    public JsonResult<Map<String,Long>> save(ArticleParam param){
        Map<String,Long> articleId  = articleFacade.save(param);
        return JsonResult.okJsonResultWithData( articleId);
    }

    /**
     *查询列表
     */
    @PostMapping("api/article/list")
    public JsonResult<List<ArticleResp> > list(@RequestBody ArticleQueryParam param){
        List<ArticleResp>  articleResp = articleFacade.list(param);
        return JsonResult.okJsonResultWithData( articleResp);
    }

}
