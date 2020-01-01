package com.wwmust.manage.system.model;

import java.util.Date;

public class AricleCollect {
    private Long aricleCollectId;

    private Long aricleId;

    private Long userId;

    private Long aricleUserId;

    private Date createTime;

    private Date updateTime;

    private String enableFlag;

    public Long getAricleCollectId() {
        return aricleCollectId;
    }

    public void setAricleCollectId(Long aricleCollectId) {
        this.aricleCollectId = aricleCollectId;
    }

    public Long getAricleId() {
        return aricleId;
    }

    public void setAricleId(Long aricleId) {
        this.aricleId = aricleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAricleUserId() {
        return aricleUserId;
    }

    public void setAricleUserId(Long aricleUserId) {
        this.aricleUserId = aricleUserId;
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

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag == null ? null : enableFlag.trim();
    }
}