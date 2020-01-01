package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.dto.article.ArticleDetailDto;
import com.wwmust.manage.system.dto.article.ArticleDto;
import com.wwmust.manage.system.model.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {
    int deleteByPrimaryKey(Long articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> list(@Param("article") ArticleDto articleDto);

    ArticleDetailDto detail(@Param("articleId") String articleId);

    List<Article> getArticleByUserIdAndType(String userId,String type);

    List<Article> getArticleByCollectUserId(@Param("userId")String userId);

    List<Article> getDraftArticleByUserId(@Param("userId")String userId);

    List<Article> gettArticleByUserId(@Param("userId")String userId);
}