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
import com.github.pagehelper.PageInfo;
import com.wwmust.manage.system.common.exception.DataInvalidataException;
import com.wwmust.manage.system.common.exception.SystemException;
import com.wwmust.manage.system.common.utils.DateUtil;
import com.wwmust.manage.system.config.SnowflakeWorker;
import com.wwmust.manage.system.dao.*;
import com.wwmust.manage.system.dto.article.ArticleDetailDto;
import com.wwmust.manage.system.dto.article.ArticleDto;
import com.wwmust.manage.system.facade.ArticleFacade;
import com.wwmust.manage.system.facade.param.article.ArticleParam;
import com.wwmust.manage.system.facade.param.article.ArticleQueryParam;
import com.wwmust.manage.system.facade.resp.article.ArticleDetailResp;
import com.wwmust.manage.system.facade.resp.article.ArticleResp;
import com.wwmust.manage.system.facade.resp.article.ArticleSkinStypeResp;
import com.wwmust.manage.system.model.*;
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
    private AricleCollectMapper aricleCollectMapper;

    @Autowired
    private UserFocusMapper userFocusMapper;




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
       /* try {
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
        }*/
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
            ArticleDetail articleDetail = new ArticleDetail();
            articleDetail.setArticleDetailId(articleId);
            articleDetail.setArticleId(articleId);
            articleDetail.setApprovalNum(0);
            articleDetail.setCollectNum(0);
            articleDetail.setAttentionNum(0);
            articleDetail.setOpposeNum(0);
            articleDetail.setViewNum(0);
            articleDetail.setSysStarId("12");
            articleDetailMapper.insertSelective(articleDetail);
        }
        return map;
    }

    /**
     * 查询文章集合
     * @return
     */
    @Override
    public PageInfo<ArticleResp> list(ArticleQueryParam param) {
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
        if (ariticleDto.getCategoryId() != null && ariticleDto.getCategoryId().toString().equals("200")) {
            ariticleDto.setIsHot("1");
            ariticleDto.setCategoryId(null);
        }
        if (ariticleDto.getCategoryId() != null && ariticleDto.getCategoryId().toString().equals("300")) {
            ariticleDto.setIsNew("1");
            ariticleDto.setCategoryId(null);
        }
     /*  List<SysImage> sysImages =  sysImageMapper.getImageList();

       List<SysStar> sysStars =  sysStarMapper.getSysStarList();
*/

        List<Article> articles=  articleMapper.list(ariticleDto);
        List<ArticleResp> resps =  new ArrayList<>();
        StringBuffer sb  = new StringBuffer();
        if(!CollectionUtils.isEmpty(articles)){
            articles.forEach(article -> {
                sb.append(" and article_id = "+ article.getArticleId());
            });
        }

        List<ArticleDetail> detailList = null;
        if(!StringUtils.isEmpty(sb)){
            detailList =  articleDetailMapper.getArticleDeatilList(sb.toString());

        }

        if(!CollectionUtils.isEmpty(articles)){
            List<ArticleDetail> finalDetailList = detailList;
            articles.forEach(article -> {
                ArticleResp resp = new ArticleResp();
                String timeDifference = DateUtil.getTimeDifference(article.getUpdateTime(), new Date());
                resp.setTime(timeDifference);
                BeanUtils.copyProperties(article,resp);
                resp.setUserId(article.getCreateUser());
                resp.setUserImgUrl(article.getUserImgUrl());
                resp.setUserName(article.getNickName());
                resp.setArticleId(article.getArticleId().toString());
                if (finalDetailList != null) {
                    finalDetailList.forEach(detail -> {
                        if (detail.getArticleId().equals(article.getArticleId())) {
                            resp.setApprovalNum(detail.getApprovalNum());
                            resp.setAttentionNum(detail.getAttentionNum());
                            resp.setCollectNum(detail.getCollectNum());
                            resp.setOpposeNum(detail.getOpposeNum());
                            resp.setViewNum(detail.getViewNum());
                            resp.setSysStarId(detail.getSysStarId());
                            resp.setSysStarName(detail.getSysStarName());
                        }
                    });
                } else {
                    resp.setApprovalNum(0);
                    resp.setAttentionNum(0);
                    resp.setCollectNum(0);
                    resp.setOpposeNum(0);
                    resp.setViewNum(0);
                }

                resps.add(resp);
            });
        }

        PageInfo<ArticleResp> pageInfo = new PageInfo<>(resps);
        return pageInfo ;
    }

    @Override
    public ArticleDetailResp detail(String articleId) {
        try {
            ArticleDetailDto articleDetailDto = articleMapper.detail(articleId);
            //阅读量加1
            articleDetailMapper.updateDetail("3",articleId);
            if (articleDetailDto != null) {
                ArticleDetailResp resp = new ArticleDetailResp();
                BeanUtils.copyProperties(articleDetailDto,resp);
                resp.setUpdateTime(DateUtil.secFormat(articleDetailDto.getUpdateTime()));
                resp.setCreateTime(DateUtil.secFormat(articleDetailDto.getCreateTime()));
                resp.setUserName(articleDetailDto.getNickName());
                resp.setUserId(articleDetailDto.getCreateUser());
                return resp;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw  new SystemException("系统异常请稍后重试！");
        }
    }

    @Override
    public void operat(String userId, String type,String operatType, String articleId,String  articleUserId) {
        if(!StringUtils.isEmpty(userId)){
            if("1".equalsIgnoreCase(type)){
                //关注
                if(operatType.equalsIgnoreCase("Y")){
                    //查询用户是否关注该文章
                    if(userFocusMapper.selectByArticleUserIdAndUserId(userId,articleUserId)){
                        return;
                    }
                    UserFocus userFocus = new UserFocus();
                    userFocus.setFocusUserId(new Long(articleUserId));
                    userFocus.setCreateTime(new Date());
                    userFocus.setUpdateTime(new Date());
                    userFocus.setUserId(new Long(userId));
                    userFocusMapper.insertSelective(userFocus);
                }else{
                    userFocusMapper.deleteByArticleUserIdAndUserId(userId,articleUserId);
                }
            }else if("2".equalsIgnoreCase(type)){
                //收藏
                if(operatType.equalsIgnoreCase("Y")){
                    //查询用户是否关注该文章
                    if(aricleCollectMapper.selectByArticleIdAndUserId(userId,articleId)){
                        return;
                    }
                    AricleCollect aricleCollect = new AricleCollect();
                    aricleCollect.setAricleCollectId(SnowflakeWorker.generateId());
                    aricleCollect.setAricleId(new Long(articleId));
                    aricleCollect.setCreateTime(new Date());
                    aricleCollect.setUpdateTime(new Date());
                    aricleCollect.setAricleUserId(new Long(articleUserId));
                    aricleCollect.setUserId(new Long(userId));
                    aricleCollectMapper.insertSelective(aricleCollect);
                }else{
                    aricleCollectMapper.deleteByArticleIdAndUserId(userId,articleId);
                }
            }
            articleDetailMapper.updateDetail(type,articleId);
        }else {
            articleDetailMapper.updateDetail(type,articleId);
        }
    }

    @Override
    public PageInfo<ArticleResp> getArticleByUserIdAndType(ArticleQueryParam param) {
        if (StringUtils.isEmpty(param.getUserId())) {
            return null;
        }
        if (param.getPageSize() == 0) {
            param.setPageSize(10);
        }
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<Article> articles = null;
        if (StringUtils.isEmpty(param.getType())) {
            return null;
        } else if (param.getType().equalsIgnoreCase("0")) {
            //我的收藏
             articles = articleMapper.getArticleByCollectUserId(param.getUserId());
        }else if(param.getType().equalsIgnoreCase("1")){
            //我的草稿
             articles = articleMapper.getDraftArticleByUserId(param.getUserId());
        }else if(param.getType().equals("2")){
            //我的文章
            articles = articleMapper.gettArticleByUserId(param.getUserId());
        }
        List<ArticleResp> articleResps = new ArrayList<>();
        if(articles != null){
            articles.forEach(article -> {
                ArticleResp articleResp = new ArticleResp();
                BeanUtils.copyProperties(article,articleResp);
                articleResp.setTime(DateUtil.format( article.getCreateTime(),"yyyy-MM-dd hh:mm"));
                articleResps.add(articleResp);
            });
        }
        PageInfo<ArticleResp> pageInfo = new PageInfo<>(articleResps);
        return pageInfo;
    }
}
