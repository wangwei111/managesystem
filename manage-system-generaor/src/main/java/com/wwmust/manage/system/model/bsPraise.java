package com.wwmust.manage.system.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bs_praise")
public class bsPraise {
    @Id
    @Column(name = "praise_id")
    private Long praiseId;

    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "article_user_id")
    private Long articleUserId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "is_valid")
    private Short isValid;

    /**
     * @return praise_id
     */
    public Long getPraiseId() {
        return praiseId;
    }

    /**
     * @param praiseId
     */
    public void setPraiseId(Long praiseId) {
        this.praiseId = praiseId;
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
}