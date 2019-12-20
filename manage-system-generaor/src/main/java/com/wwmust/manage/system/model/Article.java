package com.wwmust.manage.system.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Article {
    @Id
    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "skin_id")
    private Long skinId;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "topic_id")
    private Long topicId;

    @Column(name = "is_default")
    private String isDefault;

    @Column(name = "is_hot")
    private String isHot;

    @Column(name = "is_sensitive")
    private String isSensitive;

    private BigDecimal longitude;

    private BigDecimal latitude;

    @Column(name = "is_public")
    private String isPublic;

    @Column(name = "is_draft")
    private String isDraft;

    @Column(name = "article_title")
    private String articleTitle;

    /**
     * 来源（抽取账号名称）
     */
    private String source;

    /**
     * 是否审核通过
     */
    @Column(name = "is_audit")
    private String isAudit;

    /**
     * 浏览量
     */
    @Column(name = "page_view_num")
    private Integer pageViewNum;

    @Column(name = "article_content")
    private String articleContent;

    /**
     * @return article_id
     */
    public Long getArticleId() {
        return articleId;
    }

    /**
     * @param articleId
     */
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    /**
     * @return category_id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return skin_id
     */
    public Long getSkinId() {
        return skinId;
    }

    /**
     * @param skinId
     */
    public void setSkinId(Long skinId) {
        this.skinId = skinId;
    }

    /**
     * @return create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_user
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * @param updateUser
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return topic_id
     */
    public Long getTopicId() {
        return topicId;
    }

    /**
     * @param topicId
     */
    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    /**
     * @return is_default
     */
    public String getIsDefault() {
        return isDefault;
    }

    /**
     * @param isDefault
     */
    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }

    /**
     * @return is_hot
     */
    public String getIsHot() {
        return isHot;
    }

    /**
     * @param isHot
     */
    public void setIsHot(String isHot) {
        this.isHot = isHot == null ? null : isHot.trim();
    }

    /**
     * @return is_sensitive
     */
    public String getIsSensitive() {
        return isSensitive;
    }

    /**
     * @param isSensitive
     */
    public void setIsSensitive(String isSensitive) {
        this.isSensitive = isSensitive == null ? null : isSensitive.trim();
    }

    /**
     * @return longitude
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * @param longitude
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * @return latitude
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * @param latitude
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * @return is_public
     */
    public String getIsPublic() {
        return isPublic;
    }

    /**
     * @param isPublic
     */
    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic == null ? null : isPublic.trim();
    }

    /**
     * @return is_draft
     */
    public String getIsDraft() {
        return isDraft;
    }

    /**
     * @param isDraft
     */
    public void setIsDraft(String isDraft) {
        this.isDraft = isDraft == null ? null : isDraft.trim();
    }

    /**
     * @return article_title
     */
    public String getArticleTitle() {
        return articleTitle;
    }

    /**
     * @param articleTitle
     */
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    /**
     * 获取来源（抽取账号名称）
     *
     * @return source - 来源（抽取账号名称）
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置来源（抽取账号名称）
     *
     * @param source 来源（抽取账号名称）
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 获取是否审核通过
     *
     * @return is_audit - 是否审核通过
     */
    public String getIsAudit() {
        return isAudit;
    }

    /**
     * 设置是否审核通过
     *
     * @param isAudit 是否审核通过
     */
    public void setIsAudit(String isAudit) {
        this.isAudit = isAudit == null ? null : isAudit.trim();
    }

    /**
     * 获取浏览量
     *
     * @return page_view_num - 浏览量
     */
    public Integer getPageViewNum() {
        return pageViewNum;
    }

    /**
     * 设置浏览量
     *
     * @param pageViewNum 浏览量
     */
    public void setPageViewNum(Integer pageViewNum) {
        this.pageViewNum = pageViewNum;
    }

    /**
     * @return article_content
     */
    public String getArticleContent() {
        return articleContent;
    }

    /**
     * @param articleContent
     */
    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}