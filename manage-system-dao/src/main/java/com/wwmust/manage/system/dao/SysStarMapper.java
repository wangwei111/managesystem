package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.model.SysStar;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Repository
public interface SysStarMapper extends BaseMapper<SysStar> {
    @Select("select * from sys_star")
    List<SysStar> getSysStarList();
}