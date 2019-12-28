/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.facade.resp.article;

import java.math.BigDecimal;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 12/07/2019 17:34
 */
public class ArticleDetailResp {

    private Long articleId;

    private Long categoryId;

    private Long skinId;

    //创建人id
    private String createUser;
    //话题id
    private  Long topicId;
    //话题名称
    private String topicName;

    //暂存和保存 1保存；0暂存
    private String isSave;
    //时间
    private  String time;
    private String userId;
    private String userName;
    private String userImgUrl;
    private  String articleContent;
    //星球
    private String sysStarId;
    //名称
    private String sysStarName;

    /**
     * 赞同数
     */
    private Integer approvalNum;

    private Integer opposeNum;

    /**
     * 收藏数
     */
    private Integer collectNum;

    /**
     * 浏览数
     */
    private Integer viewNum;

    /**
     * 关注数
     */
    private Integer attentionNum;
    //来源
    private String source;

    //文章标题
    private  String articleTitle;

    private String createTime;
    private String updateTime;

    public String getCreateTime() {
        return createTime;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getSysStarId() {
        return sysStarId;
    }

    public void setSysStarId(String sysStarId) {
        this.sysStarId = sysStarId;
    }

    public String getSysStarName() {
        return sysStarName;
    }

    public void setSysStarName(String sysStarName) {
        this.sysStarName = sysStarName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getApprovalNum() {
        return approvalNum;
    }

    public void setApprovalNum(Integer approvalNum) {
        this.approvalNum = approvalNum;
    }

    public Integer getOpposeNum() {
        return opposeNum;
    }

    public void setOpposeNum(Integer opposeNum) {
        this.opposeNum = opposeNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    public Integer getAttentionNum() {
        return attentionNum;
    }

    public void setAttentionNum(Integer attentionNum) {
        this.attentionNum = attentionNum;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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


    public String getIsSave() {
        return isSave;
    }

    public void setIsSave(String isSave) {
        this.isSave = isSave;
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
