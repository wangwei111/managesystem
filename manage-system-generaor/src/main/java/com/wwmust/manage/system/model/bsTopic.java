package com.wwmust.manage.system.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bs_topic")
public class bsTopic {
    @Id
    @Column(name = "topic_id")
    private Long topicId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "topic_name")
    private String topicName;

    private String region;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "is_valid")
    private Short isValid;

    @Column(name = "topic_content")
    private String topicContent;

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
     * @return topic_name
     */
    public String getTopicName() {
        return topicName;
    }

    /**
     * @param topicName
     */
    public void setTopicName(String topicName) {
        this.topicName = topicName == null ? null : topicName.trim();
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
     * @return topic_content
     */
    public String getTopicContent() {
        return topicContent;
    }

    /**
     * @param topicContent
     */
    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent == null ? null : topicContent.trim();
    }
}