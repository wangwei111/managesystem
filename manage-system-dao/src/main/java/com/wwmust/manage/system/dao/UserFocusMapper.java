package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.model.UserFocus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFocusMapper {
    int deleteByPrimaryKey(Long userFocusId);

    int insert(UserFocus record);

    int insertSelective(UserFocus record);

    UserFocus selectByPrimaryKey(Long userFocusId);

    int updateByPrimaryKeySelective(UserFocus record);

    int updateByPrimaryKey(UserFocus record);

    boolean selectByArticleUserIdAndUserId(@Param("userId") String userId,@Param("userFocusId") String articleUserId);

    void deleteByArticleUserIdAndUserId(@Param("userId") String userId,@Param("userFocusId") String articleUserId);
}