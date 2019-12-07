/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.model.FndCategory;
import com.wwmust.manage.system.model.article.ArticleSkinStype;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 12/07/2019 15:24
 */
@Repository
public interface ArticleSkinStypeMapper<T>  extends  BaseMapper<ArticleSkinStype>  {
    @Select("<script>" +
            "select " +
            "   article_skin_id," +
            "   templete_img," +
            "   is_default, " +
            "   bar_color, " +
            "   color,   " +
            "   top_color, " +
            "   bottom_color," +
            "   enable_flag" +
            " FROM article_skin_stype  where enable_flag ='Y'" +
            "<if test='articleSkinTypeId !=null '>and article_skin_id =#{articleSkinTypeId}</if>  ORDER BY sort asc"+
            "</script>"
    )
    List<ArticleSkinStype> getSkinType(@Param("articleSkinTypeId") Long articleSkinTypeId);
}
