package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.model.ArticleDetail;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Repository
public interface ArticleDetailMapper extends BaseMapper<ArticleDetail> {

    @Select("select * from article_detail where 1=1 and #{param}")
    List<ArticleDetail> getArticleDeatilList(String param);
}