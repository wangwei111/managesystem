package com.wwmust.manage.system.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bs_comment")
public class bsComment {
    @Id
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "arricle_id")
    private Long arricleId;

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "is_child")
    private Short isChild;

    @Column(name = "reply_user_id")
    private Long replyUserId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "is_valid")
    private Short isValid;

    /**
     * @return comment_id
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * @param commentId
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * @return arricle_id
     */
    public Long getArricleId() {
        return arricleId;
    }

    /**
     * @param arricleId
     */
    public void setArricleId(Long arricleId) {
        this.arricleId = arricleId;
    }

    /**
     * @return comment_content
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * @param commentContent
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    /**
     * @return is_child
     */
    public Short getIsChild() {
        return isChild;
    }

    /**
     * @param isChild
     */
    public void setIsChild(Short isChild) {
        this.isChild = isChild;
    }

    /**
     * @return reply_user_id
     */
    public Long getReplyUserId() {
        return replyUserId;
    }

    /**
     * @param replyUserId
     */
    public void setReplyUserId(Long replyUserId) {
        this.replyUserId = replyUserId;
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