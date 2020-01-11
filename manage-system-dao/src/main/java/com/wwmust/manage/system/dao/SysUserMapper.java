package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper {
    int insert(SysUser record);

    int insertSelective(SysUser record);


    SysUser chickUserName(@Param("username") String username);


    List<SysUser> getMyFocusUser(@Param("userId") String userId);

    SysUser getUserInfo(@Param("userId") String userId);

    void updatePasswordByUid(@Param("userId") long uid, @Param("password") String password);
}