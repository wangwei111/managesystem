package com.wwmust.manage.system.dao;

import com.wwmust.manage.system.model.Opinion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionMapper {
    int deleteByPrimaryKey(Long opinionId);

    int insert(Opinion record);

    int insertSelective(Opinion record);

    Opinion selectByPrimaryKey(Long opinionId);

    int updateByPrimaryKeySelective(Opinion record);

    int updateByPrimaryKeyWithBLOBs(Opinion record);

    int updateByPrimaryKey(Opinion record);
}