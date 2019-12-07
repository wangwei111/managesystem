/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.service.article;

import com.wwmust.manage.system.common.exception.SystemException;
import com.wwmust.manage.system.dao.ArticleSkinStypeMapper;
import com.wwmust.manage.system.facade.ArticleFacade;
import com.wwmust.manage.system.facade.resp.article.ArticleSkinStypeResp;
import com.wwmust.manage.system.model.article.ArticleSkinStype;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

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
    protected ArticleSkinStypeMapper articleMapper;

    /**
     * 获取模板发布模板
     * @return
     */
    @Override
    public List<ArticleSkinStypeResp> getSkinType(Long articleSkinTypeId) {
        try {
            List<ArticleSkinStype>  articleSkinStypes =   articleMapper.getSkinType(articleSkinTypeId);
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
}
