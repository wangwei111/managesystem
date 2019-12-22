/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.model.FndCategory;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 12/07/2019 14:43
 */
@Repository
public interface CategoryMapper<T>  extends BaseMapper<FndCategory> {
    @Select("select category_code as categoryCode,category_name as categoryName from fnd_category where enable_flag ='Y' order by sort asc")
    List<FndCategory> getFndCategoryList();
}
