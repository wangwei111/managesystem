/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/

import com.alibaba.fastjson.JSON;
import com.wwmust.manage.system.config.response.JsonResult;
import com.wwmust.manage.system.facade.resp.category.CategoryResp;
import com.wwmust.manage.system.service.fengin.SensitiveFengin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 12/07/2019 19:21
 */
public class FenginTest {

    @Test
    public void a(){
        List<CategoryResp> a = new ArrayList<>();
        CategoryResp categoryResp = new CategoryResp();
        categoryResp.setCategoryCode("ss");
        categoryResp.setCategoryName("bb");
        a.add(categoryResp);
System.out.println(JSON.toJSONString(a));
    }
}
