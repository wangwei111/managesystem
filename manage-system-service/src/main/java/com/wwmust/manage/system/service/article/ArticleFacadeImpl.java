/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.service.article;

import com.github.pagehelper.PageHelper;
import com.wwmust.manage.system.common.exception.DataInvalidataException;
import com.wwmust.manage.system.common.exception.SystemException;
import com.wwmust.manage.system.common.utils.DateUtil;
import com.wwmust.manage.system.config.SnowflakeWorker;
import com.wwmust.manage.system.dao.*;
import com.wwmust.manage.system.dto.article.ArticleDto;
import com.wwmust.manage.system.facade.ArticleFacade;
import com.wwmust.manage.system.facade.param.article.ArticleParam;
import com.wwmust.manage.system.facade.param.article.ArticleQueryParam;
import com.wwmust.manage.system.facade.resp.article.ArticleResp;
import com.wwmust.manage.system.facade.resp.article.ArticleSkinStypeResp;
import com.wwmust.manage.system.model.ArticleDetail;
import com.wwmust.manage.system.model.SysImage;
import com.wwmust.manage.system.model.SysStar;
import com.wwmust.manage.system.model.article.Article;
import com.wwmust.manage.system.model.article.ArticleSkinStype;
import com.wwmust.manage.system.service.fengin.SensitiveFengin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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

    @Autowired
    private ArticleDetailMapper articleDetailMapper;



    @Autowired
    private SysImageMapper sysImageMapper;


    @Autowired
    private SysStarMapper sysStarMapper;
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
     * @return
     */
    @Override
    public List<ArticleResp> list(ArticleQueryParam param) {
        if( param.getPageSize() ==0){
           param.setPageSize(10);
        }
        PageHelper.startPage(param.getPageNum(),param.getPageSize());
        ArticleDto ariticleDto =new ArticleDto();

        BeanUtils.copyProperties(param,ariticleDto);
        if(StringUtils.isEmpty(param.getCategoryId())){
            //最热
            ariticleDto.setCategoryId(new Long("200"));
        }
        if(param.getCategoryId().toString().equals("200")){
            ariticleDto.setIsHot("1");
            ariticleDto.setCategoryId(null);
        }
        if(param.getCategoryId().toString().equals("300")){
            ariticleDto.setIsNew("1");
            ariticleDto.setCategoryId(null);
        }
       List<SysImage> sysImages =  sysImageMapper.getImageList();

       List<SysStar> sysStars =  sysStarMapper.getSysStarList();


        List<Article> articles=  articleMapper.list(ariticleDto);
        List<ArticleResp> resps =  new ArrayList<>();

        StringBuffer sb  = new StringBuffer();
        if(!CollectionUtils.isEmpty(articles)){
            articles.forEach(article -> {
                sb.append(" and article_id = "+ article.getArticleId());
            });
        }

        List<ArticleDetail> detailList = null;
        if(StringUtils.isEmpty(sb)){
            detailList =  articleDetailMapper.getArticleDeatilList(sb.toString());
        }

        if(!CollectionUtils.isEmpty(articles)){
            List<ArticleDetail> finalDetailList = detailList;
            articles.forEach(article -> {
                ArticleResp resp = new ArticleResp();
                String timeDifference = DateUtil.getTimeDifference(article.getUpdateTime(), new Date());
                resp.setTime(timeDifference);
                BeanUtils.copyProperties(article,resp);

                resp.setSource(sysStars.get(0).getStarName());
                finalDetailList.forEach(detail->{
                    if( detail.getArticleId().equals(article.getArticleId())){
                       resp.setApprovalNum(detail.getApprovalNum());
                       resp.setAttentionNum(detail.getAttentionNum());
                       resp.setCollectNum(detail.getCollectNum());
                       resp.setOpposeNum(detail.getOpposeNum());
                       resp.setViewNum(detail.getViewNum());
                   }
                });
                resps.add(resp);
            });
        }
        return resps;
    }
}
