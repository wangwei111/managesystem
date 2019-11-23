package com.wwmust.manage.system.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bs_friend")
public class bsFriend {
    @Id
    @Column(name = "friend_id")
    private Long friendId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "is_valid")
    private Short isValid;

    @Column(name = "update_id")
    private Date updateId;

    /**
     * @return friend_id
     */
    public Long getFriendId() {
        return friendId;
    }

    /**
     * @param friendId
     */
    public void setFriendId(Long friendId) {
        this.friendId = friendId;
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
     * @return update_id
     */
    public Date getUpdateId() {
        return updateId;
    }

    /**
     * @param updateId
     */
    public void setUpdateId(Date updateId) {
        this.updateId = updateId;
    }
}