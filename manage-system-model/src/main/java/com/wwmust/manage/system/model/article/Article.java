package com.wwmust.manage.system.model.article;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

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
    private Byte isDefault;

    @Column(name = "is_hot")
    private Byte isHot;

    @Column(name = "is_sensitive")
    private Byte isSensitive;

    private BigDecimal longitude;

    private BigDecimal latitude;

    @Column(name = "is_public")
    private Byte isPublic;

    @Column(name = "is_draft")
    private Byte isDraft;

    @Column(name = "article_content")
    private String articleContent;

    @Column(name= "article_title")
    private String articleTitle;

    //浏览数
    @Column(name= "page_view_num")
    private Integer pageViewNum;

    //来源
    @Column(name= "source")
    private String source;

    public Integer getPageViewNum() {
        return pageViewNum;
    }

    public void setPageViewNum(Integer pageViewNum) {
        this.pageViewNum = pageViewNum;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

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
    public Byte getIsDefault() {
        return isDefault;
    }

    /**
     * @param isDefault
     */
    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * @return is_hot
     */
    public Byte getIsHot() {
        return isHot;
    }

    /**
     * @param isHot
     */
    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }

    /**
     * @return is_sensitive
     */
    public Byte getIsSensitive() {
        return isSensitive;
    }

    /**
     * @param isSensitive
     */
    public void setIsSensitive(Byte isSensitive) {
        this.isSensitive = isSensitive;
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
    public Byte getIsPublic() {
        return isPublic;
    }

    /**
     * @param isPublic
     */
    public void setIsPublic(Byte isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * @return is_draft
     */
    public Byte getIsDraft() {
        return isDraft;
    }

    /**
     * @param isDraft
     */
    public void setIsDraft(Byte isDraft) {
        this.isDraft = isDraft;
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