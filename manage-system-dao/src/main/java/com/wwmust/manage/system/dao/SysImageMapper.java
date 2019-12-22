package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.model.SysImage;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Repository
public interface SysImageMapper extends BaseMapper<SysImage> {

    @Select("select * from sys_image")
    List<SysImage> getImageList();
}