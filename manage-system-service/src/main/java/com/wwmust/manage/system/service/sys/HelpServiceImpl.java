/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.service.sys;

import com.wwmust.manage.system.config.SnowflakeWorker;
import com.wwmust.manage.system.dao.OpinionMapper;
import com.wwmust.manage.system.model.Opinion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 12/31/2019 8:21
 */
@Service
public class HelpServiceImpl implements  HelpService {

    @Autowired
    private OpinionMapper opinionMapper;

    @Override
    public void save(String message) {
        Opinion opinion = new Opinion();
        opinion.setOpinionId(SnowflakeWorker.generateId());
        opinion.setOpinionName(message);
        opinion.setCreateTime(new Date());
        opinion.setUpdateTime(new Date());
        opinionMapper.insertSelective(opinion);
    }
}
