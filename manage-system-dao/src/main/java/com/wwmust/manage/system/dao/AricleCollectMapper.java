package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.model.AricleCollect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AricleCollectMapper {
    int deleteByPrimaryKey(Long aricleCollectId);

    int insert(AricleCollect record);

    int insertSelective(AricleCollect record);

    AricleCollect selectByPrimaryKey(Long aricleCollectId);

    int updateByPrimaryKeySelective(AricleCollect record);

    int updateByPrimaryKey(AricleCollect record);

    boolean selectByArticleIdAndUserId(@Param("userId") String userId, @Param("articleId") String articleId);

    void deleteByArticleIdAndUserId(@Param("userId") String userId, @Param("articleId") String articleId);
}