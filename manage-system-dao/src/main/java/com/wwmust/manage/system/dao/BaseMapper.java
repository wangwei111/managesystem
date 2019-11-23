/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * ${DESCRIPTION}
 * 基础mappper类
 * @author wangwei<wwfdqc@126.com>
 * @date 11/17/2019 21:06
 */
public interface BaseMapper<T> extends tk.mybatis.mapper.common.BaseMapper<T>,Mapper<T>, MySqlMapper<T>{
}
