package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.model.ArticleSkinStype;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleSkinStypeMapper {
    int deleteByPrimaryKey(Long articleSkinId);

    int insert(ArticleSkinStype record);

    int insertSelective(ArticleSkinStype record);

    ArticleSkinStype selectByPrimaryKey(Long articleSkinId);

    int updateByPrimaryKeySelective(ArticleSkinStype record);

    int updateByPrimaryKey(ArticleSkinStype record);
}