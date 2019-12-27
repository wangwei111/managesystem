/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.service.category;

import com.wwmust.manage.system.common.exception.SystemException;
import com.wwmust.manage.system.dao.FndCategoryMapper;
import com.wwmust.manage.system.facade.CategoryFacade;
import com.wwmust.manage.system.facade.resp.category.CategoryResp;
import com.wwmust.manage.system.model.FndCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类实现类
 * @author wangwei<wwfdqc@126.com>
 * @date 12/07/2019 14:42
 */
@Service
@Slf4j
public class CategoryFacadeImpl implements CategoryFacade{
    @Autowired
    private FndCategoryMapper categoryMapper;

    /**
     * 查询分类信息
     * @return
     */
    @Override
    public List<CategoryResp> getFndCategoryList() {
        try{

            List<FndCategory> fndCategories=   categoryMapper.getFndCategoryList();
            List<CategoryResp> list = new ArrayList<>();
            if(fndCategories != null && fndCategories.size()>0){
                fndCategories.forEach(fndCategory -> {
                    CategoryResp categoryResp = new CategoryResp();
                    BeanUtils.copyProperties(fndCategory,categoryResp);
                    list.add(categoryResp);
                });
                return list;
            }
        }catch (Exception e){
            log.error("系统异常：{}",e.getMessage());
            throw  new SystemException("系统异常：{}",e.getMessage());
        }
        return null;
    }
}
