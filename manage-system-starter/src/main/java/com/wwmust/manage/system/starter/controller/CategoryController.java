/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.starter.controller;

import com.alibaba.fastjson.JSON;
import com.wwmust.manage.system.config.response.JsonResult;
import com.wwmust.manage.system.facade.ArticleFacade;
import com.wwmust.manage.system.facade.CategoryFacade;
import com.wwmust.manage.system.facade.resp.article.ArticleResp;
import com.wwmust.manage.system.facade.resp.category.CategoryResp;
import com.wwmust.manage.system.model.FndCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ${DESCRIPTION}
 *f分类控制器
 * @author wangwei<wwfdqc@126.com>
 * @date 12/07/2019 14:35
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryFacade categoryFacade;

    @Autowired
    private ArticleFacade articleFacade;

    /**
     * 获取类型
     * @return
     */
    @GetMapping("api/category/getCategory")
    public JsonResult< List<CategoryResp> > getFndCategory(){
        List<CategoryResp>  list = categoryFacade.getFndCategoryList();
        return JsonResult.okJsonResultWithData( list);
    }
}
