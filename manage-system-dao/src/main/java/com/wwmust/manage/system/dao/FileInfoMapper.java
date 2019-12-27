package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.model.FileInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface FileInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FileInfo record);

    int insertSelective(FileInfo record);

    FileInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FileInfo record);

    int updateByPrimaryKey(FileInfo record);
}