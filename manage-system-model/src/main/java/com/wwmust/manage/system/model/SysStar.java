package com.wwmust.manage.system.model;

import java.util.Date;

public class SysStar {
    private Long sysStarId;

    private String starName;

    private String enableFlag;

    private Date createTime;

    private Date updateTime;

    private Integer sort;

    public Long getSysStarId() {
        return sysStarId;
    }

    public void setSysStarId(Long sysStarId) {
        this.sysStarId = sysStarId;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName == null ? null : starName.trim();
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag == null ? null : enableFlag.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}