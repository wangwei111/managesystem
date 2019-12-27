package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper {
    int insert(SysUser record);

    int insertSelective(SysUser record);


    SysUser chickUserName(@Param("username") String username);
}