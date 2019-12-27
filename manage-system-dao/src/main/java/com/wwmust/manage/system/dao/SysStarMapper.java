package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.model.SysStar;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SysStarMapper {
    int deleteByPrimaryKey(Long sysStarId);

    int insert(SysStar record);

    int insertSelective(SysStar record);

    SysStar selectByPrimaryKey(Long sysStarId);

    int updateByPrimaryKeySelective(SysStar record);

    int updateByPrimaryKey(SysStar record);

    List<SysStar> getSysStarList();
}