/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.dto.article.ArticleDto;
import com.wwmust.manage.system.model.article.Article;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 12/07/2019 20:47
 */
@Repository
public interface ArticleMapper<T>  extends BaseMapper<Article> {

    @Select("<script> select * from article where 1=1 " +
            "<if test =\"categoryId !=null  or categoryId !='null' or categoryId !='200' or categoryId != '300'\">" +
            "  and category_id = #{categoryId}"+
            "</if>"+
            "<if test ='isHot== 1'>" +
            "   and is_hot=1" +
            "</if>" +
            "<if test='isNew ==1'>" +
            "  order by update_time desc"+
            "</if>"+
            "</script> ")
    List<Article> list(ArticleDto articleDto);
}
