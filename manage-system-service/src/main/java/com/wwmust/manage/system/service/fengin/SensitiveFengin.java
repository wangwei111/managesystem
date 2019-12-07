/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.service.fengin;

import com.wwmust.manage.system.config.response.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 12/07/2019 19:03
 */

@FeignClient(url="${sensitiveword.url}",name="senditive-fengin")
public interface SensitiveFengin {

    @RequestMapping(value="/filter/api/words",method = RequestMethod.POST)
    JsonResult  getFilter(@RequestBody  WordsParam param);
}
