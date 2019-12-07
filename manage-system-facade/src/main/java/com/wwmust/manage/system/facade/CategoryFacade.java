/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.facade;

import com.wwmust.manage.system.facade.resp.category.CategoryResp;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 12/07/2019 14:37
 */
public interface CategoryFacade {
    /**
     * 查询分类
     * @return
     */
    List<CategoryResp> getFndCategoryList();
}
