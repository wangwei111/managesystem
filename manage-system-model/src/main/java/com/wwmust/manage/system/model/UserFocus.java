package com.wwmust.manage.system.model;

import java.util.Date;

public class UserFocus {
    private Long userFocusId;

    private Long focusUserId;

    private Long userId;

    private Date createTime;

    private Date updateTime;

    private String enableFlag;

    public Long getUserFocusId() {
        return userFocusId;
    }

    public void setUserFocusId(Long userFocusId) {
        this.userFocusId = userFocusId;
    }

    public Long getFocusUserId() {
        return focusUserId;
    }

    public void setFocusUserId(Long focusUserId) {
        this.focusUserId = focusUserId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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