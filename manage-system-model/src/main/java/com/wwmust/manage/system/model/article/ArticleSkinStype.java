package com.wwmust.manage.system.model.article;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "article_skin_stype")
public class ArticleSkinStype {
    @Id
    @Column(name = "article_skin_id")
    private Long articleSkinId;

    @Column(name = "templete_img")
    private String templeteImg;

    @Column(name = "is_default")
    private String isDefault;

    @Column(name = "bar_color")
    private String barColor;

    private String color;

    @Column(name = "top_color")
    private String topColor;

    @Column(name = "bottom_color")
    private String bottomColor;

    @Column(name = "enable_flag")
    private String enableFlag;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "sort")
    private int sort;

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    /**
     * @return article_skin_id
     */
    public Long getArticleSkinId() {
        return articleSkinId;
    }

    /**
     * @param articleSkinId
     */
    public void setArticleSkinId(Long articleSkinId) {
        this.articleSkinId = articleSkinId;
    }

    /**
     * @return templete_img
     */
    public String getTempleteImg() {
        return templeteImg;
    }

    /**
     * @param templeteImg
     */
    public void setTempleteImg(String templeteImg) {
        this.templeteImg = templeteImg == null ? null : templeteImg.trim();
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
     * @return bar_color
     */
    public String getBarColor() {
        return barColor;
    }

    /**
     * @param barColor
     */
    public void setBarColor(String barColor) {
        this.barColor = barColor == null ? null : barColor.trim();
    }

    /**
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color
     */
    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    /**
     * @return top_color
     */
    public String getTopColor() {
        return topColor;
    }

    /**
     * @param topColor
     */
    public void setTopColor(String topColor) {
        this.topColor = topColor == null ? null : topColor.trim();
    }

    /**
     * @return bottom_color
     */
    public String getBottomColor() {
        return bottomColor;
    }

    /**
     * @param bottomColor
     */
    public void setBottomColor(String bottomColor) {
        this.bottomColor = bottomColor == null ? null : bottomColor.trim();
    }

    /**
     * @return enable_flag
     */
    public String getEnableFlag() {
        return enableFlag;
    }

    /**
     * @param enableFlag
     */
    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag == null ? null : enableFlag.trim();
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
}