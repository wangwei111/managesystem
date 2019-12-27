package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.model.SensitiveWordLibrary;
import org.springframework.stereotype.Repository;

@Repository
public interface SensitiveWordLibraryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SensitiveWordLibrary record);

    int insertSelective(SensitiveWordLibrary record);

    SensitiveWordLibrary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SensitiveWordLibrary record);

    int updateByPrimaryKey(SensitiveWordLibrary record);
}