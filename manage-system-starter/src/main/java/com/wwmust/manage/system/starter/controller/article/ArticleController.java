/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.starter.controller.article;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.wwmust.manage.system.config.response.JsonResult;
import com.wwmust.manage.system.facade.ArticleFacade;
import com.wwmust.manage.system.facade.UserFacade;
import com.wwmust.manage.system.facade.param.article.ArticleParam;
import com.wwmust.manage.system.facade.param.article.ArticleQueryParam;
import com.wwmust.manage.system.facade.resp.UserInfoResp;
import com.wwmust.manage.system.facade.resp.article.ArticleDetailResp;
import com.wwmust.manage.system.facade.resp.article.ArticleResp;
import com.wwmust.manage.system.facade.resp.article.ArticleSkinStypeResp;
import com.wwmust.manage.system.starter.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private  UserFacade userFacade;

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
    public JsonResult<?> save(@RequestBody  ArticleParam param,HttpServletResponse response, HttpServletRequest request){
        UserContext userContext= new UserContext();
        String userId = userContext.getUserId(request);
        if (StringUtils.isEmpty(userId)) {
            return JsonResult.okJsonResultWithData("用户为空！");
        }else {
            param.setCreateUser(userId);
        }
        Map<String,Long> articleId  = articleFacade.save(param);
        return JsonResult.okJsonResultWithData( articleId);
    }

    /**
     *查询列表
     */
    @PostMapping("api/article/list")
    public JsonResult<PageInfo<ArticleResp>> list(@RequestBody ArticleQueryParam param){
        return JsonResult.okJsonResultWithData( articleFacade.list(param));
    }


    /**
     *查询列表
     */
    @GetMapping("api/article/detail/{articleId}")
    public JsonResult<ArticleDetailResp > detail(@PathVariable String articleId){
        ArticleDetailResp articleResp = articleFacade.detail(articleId);
        return JsonResult.okJsonResultWithData( articleResp);
    }



    /**
     *点赞收藏关注
     */
    @GetMapping("api/article/operat/{type}/{operatType}/{articleId}")
    public JsonResult operat(HttpServletResponse response, HttpServletRequest request,@PathVariable String type,
                             @PathVariable String  operatType,@PathVariable String articleId,@PathVariable String articleUserId){
        UserContext userContext= new UserContext();
        String userId = userContext.getUserId(request);
        articleFacade.operat(userId,type,operatType,articleId,articleUserId);
        return JsonResult.okJsonResultWithData("成功！");
    }

    /**
     * 我的文章
     * @param response
     * @param request
     * @return
     */
    @PostMapping("api/article/myarticle")
    public JsonResult< PageInfo<ArticleResp> > myarticle(HttpServletResponse response, HttpServletRequest request,@RequestBody ArticleQueryParam param){
        UserContext userContext= new UserContext();
        String userId = userContext.getUserId(request);
        param.setUserId(userId);
        param.setType("2");
        PageInfo<ArticleResp> respPageInfo = articleFacade.getArticleByUserIdAndType(param);
        return JsonResult.okJsonResultWithData(respPageInfo);
    }

    /**
     * 我的关注
     * @param response
     * @param request
     * @return
     */
    @PostMapping("api/article/myfocus")
    public JsonResult<PageInfo<UserInfoResp> > myfocus(HttpServletResponse response, HttpServletRequest request,Integer pageNum, Integer pageSize){
        UserContext userContext = new  UserContext();
        String userId = userContext.getUserId(request);
        PageInfo<UserInfoResp> respPageInfo=  userFacade.getMyFocusUser(userId,pageNum,pageSize);
        return JsonResult.okJsonResultWithData(respPageInfo);
    }

    /**
     * 我的草稿
     * @param response
     * @param request
     * @return
     */
    @PostMapping("api/article/mydraft")
    public JsonResult<   PageInfo<ArticleResp> > mydraft(HttpServletResponse response, HttpServletRequest request,@RequestBody ArticleQueryParam param){
        UserContext userContext= new UserContext();
        String userId = userContext.getUserId(request);
        param.setUserId(userId);
        param.setType("1");
        PageInfo<ArticleResp> respPageInfo = articleFacade.getArticleByUserIdAndType(param);
        return JsonResult.okJsonResultWithData(respPageInfo);
    }

    /**
     * 我的收藏
     * @param response
     * @param request
     * @return
     */
    @PostMapping("api/article/mycollect")
    public JsonResult< PageInfo<ArticleResp>> mycollect(HttpServletResponse response, HttpServletRequest request,@RequestBody ArticleQueryParam param){
        UserContext userContext= new UserContext();
        String userId = userContext.getUserId(request);
        param.setUserId(userId);
        param.setType("0");
        PageInfo<ArticleResp> respPageInfo = articleFacade.getArticleByUserIdAndType(param);
        return JsonResult.okJsonResultWithData(respPageInfo);
    }

}
