package com.wwmust.manage.system.model;

import java.util.Date;

public class ArticleSkinStype {
    private Long articleSkinId;

    private String templeteImg;

    private String isDefault;

    private String barColor;

    private String color;

    private String topColor;

    private String bottomColor;

    private String enableFlag;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private Integer sort;

    public Long getArticleSkinId() {
        return articleSkinId;
    }

    public void setArticleSkinId(Long articleSkinId) {
        this.articleSkinId = articleSkinId;
    }

    public String getTempleteImg() {
        return templeteImg;
    }

    public void setTempleteImg(String templeteImg) {
        this.templeteImg = templeteImg == null ? null : templeteImg.trim();
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }

    public String getBarColor() {
        return barColor;
    }

    public void setBarColor(String barColor) {
        this.barColor = barColor == null ? null : barColor.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getTopColor() {
        return topColor;
    }

    public void setTopColor(String topColor) {
        this.topColor = topColor == null ? null : topColor.trim();
    }

    public String getBottomColor() {
        return bottomColor;
    }

    public void setBottomColor(String bottomColor) {
        this.bottomColor = bottomColor == null ? null : bottomColor.trim();
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag == null ? null : enableFlag.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
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