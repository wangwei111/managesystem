package com.wwmust.manage.system.model;

import java.util.Date;

public class Opinion {
    private Long opinionId;

    private Date updateTime;

    private Date createTime;

    private String enableIp;

    private String opinionName;

    public Long getOpinionId() {
        return opinionId;
    }

    public void setOpinionId(Long opinionId) {
        this.opinionId = opinionId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEnableIp() {
        return enableIp;
    }

    public void setEnableIp(String enableIp) {
        this.enableIp = enableIp == null ? null : enableIp.trim();
    }

    public String getOpinionName() {
        return opinionName;
    }

    public void setOpinionName(String opinionName) {
        this.opinionName = opinionName == null ? null : opinionName.trim();
    }
}