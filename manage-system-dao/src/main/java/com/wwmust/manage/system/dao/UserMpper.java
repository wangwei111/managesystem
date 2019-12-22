/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 11/17/2019 21:12
 */
@Repository
public interface UserMpper<T>  extends BaseMapper<User> {
    @Select ("SELECT * FROM user WHERE username =#{username} OR account_number =#{username} OR email =#{username} OR phone_number =#{username}")
    User chickUserName(@Param("username") String username);
}
