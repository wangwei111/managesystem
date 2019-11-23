package com.wwmust.manage.system.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bs_attention_article")
public class bsAttentionArticle {
    @Id
    @Column(name = "attention_id")
    private Long attentionId;

    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "article_user_id")
    private Long articleUserId;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "is_valid")
    private Short isValid;

    /**
     * @return attention_id
     */
    public Long getAttentionId() {
        return attentionId;
    }

    /**
     * @param attentionId
     */
    public void setAttentionId(Long attentionId) {
        this.attentionId = attentionId;
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
     * @return article_user_id
     */
    public Long getArticleUserId() {
        return articleUserId;
    }

    /**
     * @param articleUserId
     */
    public void setArticleUserId(Long articleUserId) {
        this.articleUserId = articleUserId;
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
}