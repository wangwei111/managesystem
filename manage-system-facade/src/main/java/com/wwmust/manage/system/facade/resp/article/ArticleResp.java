/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.facade.resp.article;

import com.github.pagehelper.Page;

import java.math.BigDecimal;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 12/07/2019 17:34
 */
public class ArticleResp{

    private Long articleId;

    private Long categoryId;

    private Long skinId;

    //创建人id
    private String createUser;
    //创建人头像
    private  String createUserImgUrl;
    //话题id
    private  Long topicId;
    //话题名称
    private String topicName;


    //是否公开
    private String isPublic;

    private BigDecimal  longitude;
    private BigDecimal latitude;

    //暂存和保存 1保存；0暂存
    private String isSave;



   //是否是草稿
    private String isDraft;

    //文章标题
    private  String articleTitle;

    public String getCreateUserImgUrl() {
        return createUserImgUrl;
    }

    public void setCreateUserImgUrl(String createUserImgUrl) {
        this.createUserImgUrl = createUserImgUrl;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getIsDraft() {
        return isDraft;
    }

    public void setIsDraft(String isDraft) {
        this.isDraft = isDraft;
    }

    public String getIsSave() {
        return isSave;
    }

    public void setIsSave(String isSave) {
        this.isSave = isSave;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSkinId() {
        return skinId;
    }

    public void setSkinId(Long skinId) {
        this.skinId = skinId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

}
