/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.dto.article.AriticleDto;
import com.wwmust.manage.system.model.article.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 12/07/2019 20:47
 */
@Repository
public interface ArticleMapper<T>  extends  BaseMapper<Article>   {

    List<Article> list(@Param("ariticleDto") AriticleDto ariticleDto);
}
