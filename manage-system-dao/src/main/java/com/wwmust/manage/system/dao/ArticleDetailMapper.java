package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.model.ArticleDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDetailMapper {
    int deleteByPrimaryKey(Long articleDetailId);

    int insert(ArticleDetail record);

    int insertSelective(ArticleDetail record);

    ArticleDetail selectByPrimaryKey(Long articleDetailId);

    int updateByPrimaryKeySelective(ArticleDetail record);

    int updateByPrimaryKey(ArticleDetail record);

    List<ArticleDetail> getArticleDeatilList(@Param("sql") String sql);

    void updateDetail(@Param("type")String type,@Param("articleId") String articleId);
}