package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.model.SysImage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysImageMapper {
    int deleteByPrimaryKey(Long sysImgId);

    int insert(SysImage record);

    int insertSelective(SysImage record);

    SysImage selectByPrimaryKey(Long sysImgId);

    int updateByPrimaryKeySelective(SysImage record);

    int updateByPrimaryKey(SysImage record);

    List<SysImage> getImageList();
}