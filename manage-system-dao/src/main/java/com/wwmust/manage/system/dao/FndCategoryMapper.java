package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.model.FndCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FndCategoryMapper {
    int deleteByPrimaryKey(Long categoryId);

    int insert(FndCategory record);

    int insertSelective(FndCategory record);

    FndCategory selectByPrimaryKey(Long categoryId);

    int updateByPrimaryKeySelective(FndCategory record);

    int updateByPrimaryKey(FndCategory record);

    List<FndCategory> getFndCategoryList();
}