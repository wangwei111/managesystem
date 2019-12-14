/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.service.article;

import com.alibaba.fastjson.JSON;
import com.wwmust.manage.system.common.exception.DataInvalidataException;
import com.wwmust.manage.system.common.exception.SystemException;
import com.wwmust.manage.system.config.SnowflakeWorker;
import com.wwmust.manage.system.config.response.JsonResult;
import com.wwmust.manage.system.dao.ArticleMapper;
import com.wwmust.manage.system.dao.ArticleSkinStypeMapper;
import com.wwmust.manage.system.facade.ArticleFacade;
import com.wwmust.manage.system.facade.param.article.ArticleParam;
import com.wwmust.manage.system.facade.param.article.ArticleQueryParam;
import com.wwmust.manage.system.facade.resp.article.ArticleResp;
import com.wwmust.manage.system.facade.resp.article.ArticleSkinStypeResp;
import com.wwmust.manage.system.model.article.Article;
import com.wwmust.manage.system.model.article.ArticleSkinStype;
import com.wwmust.manage.system.service.fengin.SensitiveFengin;
import com.wwmust.manage.system.service.fengin.WordsParam;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * ${DESCRIPTION}
 *文章实现类
 * @author wangwei<wwfdqc@126.com>
 * @date 12/07/2019 15:20
 */
@Service
@Slf4j
public class ArticleFacadeImpl implements ArticleFacade {

    @Autowired
    protected ArticleSkinStypeMapper articleSkinStypeMapper;

    @Autowired
    private SensitiveFengin sensitiveFengin;

    @Autowired
    private ArticleMapper articleMapper;
    /**
     * 获取模板发布模板
     * @return
     */
    @Override
    public List<ArticleSkinStypeResp> getSkinType(Long articleSkinTypeId) {
        try {
            List<ArticleSkinStype>  articleSkinStypes =   articleSkinStypeMapper.getSkinType(articleSkinTypeId);
            if(!CollectionUtils.isEmpty(articleSkinStypes)){
                List<ArticleSkinStypeResp> articleSkinStypeResps = new ArrayList<>(articleSkinStypes.size());
                articleSkinStypes.forEach(articleSkinStype -> {
                    ArticleSkinStypeResp articleSkinStypeResp  = new ArticleSkinStypeResp();
                    BeanUtils.copyProperties(articleSkinStype,articleSkinStypeResp);
                    articleSkinStypeResps.add(articleSkinStypeResp);
                });
                return articleSkinStypeResps;
            }
        }catch (Exception e){
            log.error("查询皮肤异常：{}" ,e.getMessage());
            throw  new SystemException("系统异常");
        }
        return null;
    }

    /**
     * 文章保存及修改
     * @param param
     * @return
     */
    @Override
    public Map<String, Long> save(ArticleParam param) {
        Map<String, Long> map = new HashMap<>();
        if(param ==null){
            new DataInvalidataException("参数为空！");
        }
        Article article = new Article();
        BeanUtils.copyProperties(param,article);
        if(param.getArticleId() != null){
            map.put("articleId",param.getArticleId());
            article.setUpdateTime(new Date());
            //修改操作
            articleMapper.updateByPrimaryKeySelective(article);
        }else {
            //新增操作
            article.setCreateTime(new Date());
            article.setUpdateTime(new Date());
            Long articleId = SnowflakeWorker.generateId();
            article.setArticleId(articleId);
            map.put("articleId",articleId);
            articleMapper.insertSelective(article);
        }
        return map;
    }

    /**
     * 查询文章集合
     * @param param
     * @return
     */
    @Override
    public ArticleResp list(ArticleQueryParam param) {


        return null;
    }
}
