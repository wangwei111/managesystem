package com.wwmust.manage.system.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "bs_article")
public class BsArticle {
    @Id
    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "article_name")
    private String articleName;

    @Column(name = "is_nack_name")
    private Short isNackName;

    private String region;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "is_valid")
    private Short isValid;

    @Column(name = "topic_id")
    private Long topicId;

    @Column(name = "is_hot")
    private Integer isHot;

    @Column(name = "hot_index")
    private Integer hotIndex;

    @Column(name = "arricle_content")
    private String arricleContent;

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
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return article_name
     */
    public String getArticleName() {
        return articleName;
    }

    /**
     * @param articleName
     */
    public void setArticleName(String articleName) {
        this.articleName = articleName == null ? null : articleName.trim();
    }

    /**
     * @return is_nack_name
     */
    public Short getIsNackName() {
        return isNackName;
    }

    /**
     * @param isNackName
     */
    public void setIsNackName(Short isNackName) {
        this.isNackName = isNackName;
    }

    /**
     * @return region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return update_date
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return is_valid
     */
    public Short getIsValid() {
        return isValid;
    }

    /**
     * @param isValid
     */
    public void setIsValid(Short isValid) {
        this.isValid = isValid;
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
     * @return is_hot
     */
    public Integer getIsHot() {
        return isHot;
    }

    /**
     * @param isHot
     */
    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    /**
     * @return hot_index
     */
    public Integer getHotIndex() {
        return hotIndex;
    }

    /**
     * @param hotIndex
     */
    public void setHotIndex(Integer hotIndex) {
        this.hotIndex = hotIndex;
    }

    /**
     * @return arricle_content
     */
    public String getArricleContent() {
        return arricleContent;
    }

    /**
     * @param arricleContent
     */
    public void setArricleContent(String arricleContent) {
        this.arricleContent = arricleContent == null ? null : arricleContent.trim();
    }
}