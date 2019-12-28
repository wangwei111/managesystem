/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.facade;

import com.wwmust.manage.system.facade.param.article.ArticleParam;
import com.wwmust.manage.system.facade.param.article.ArticleQueryParam;
import com.wwmust.manage.system.facade.resp.article.ArticleDetailResp;
import com.wwmust.manage.system.facade.resp.article.ArticleResp;
import com.wwmust.manage.system.facade.resp.article.ArticleSkinStypeResp;

import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 12/07/2019 15:19
 */
public interface ArticleFacade {
    /**
     * 获取发布暂存模板皮肤
     * @return
     */
    List<ArticleSkinStypeResp> getSkinType(Long articleSkinTypeId);

    /**
     * 文章保存及修改
     * @return
     */
    Map<String,Long> save(ArticleParam param);

    /**
     * 查询文章集合
     * @param param
     * @return
     */
    List<ArticleResp>  list(ArticleQueryParam param);

    /**
     * 根据文章的id获取文章详情
     * @param articleId
     * @return
     */
    ArticleDetailResp detail(String articleId);

    /**
     * 根据用户的类型，文章id更新文章数
     * @param userId
     * @param type
     * @param articleId
     */
    void operat(String userId, String type, String articleId);
}
