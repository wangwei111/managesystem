package com.wwmust.manage.system.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_image")
public class SysImage {
    @Id
    @Column(name = "sys_img_id")
    private Long sysImgId;

    @Column(name = "user_id")
    private Long userId;

    /**
     * 是否为系统 1是，0否
     */
    @Column(name = "is_sys")
    private String isSys;

    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否有效
     */
    @Column(name = "enable_flag")
    private String enableFlag;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 操作人
     */
    private String operate;

    /**
     * @return sys_img_id
     */
    public Long getSysImgId() {
        return sysImgId;
    }

    /**
     * @param sysImgId
     */
    public void setSysImgId(Long sysImgId) {
        this.sysImgId = sysImgId;
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
     * 获取是否为系统 1是，0否
     *
     * @return is_sys - 是否为系统 1是，0否
     */
    public String getIsSys() {
        return isSys;
    }

    /**
     * 设置是否为系统 1是，0否
     *
     * @param isSys 是否为系统 1是，0否
     */
    public void setIsSys(String isSys) {
        this.isSys = isSys == null ? null : isSys.trim();
    }

    /**
     * @return img_url
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取是否有效
     *
     * @return enable_flag - 是否有效
     */
    public String getEnableFlag() {
        return enableFlag;
    }

    /**
     * 设置是否有效
     *
     * @param enableFlag 是否有效
     */
    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag == null ? null : enableFlag.trim();
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
     * 获取操作人
     *
     * @return operate - 操作人
     */
    public String getOperate() {
        return operate;
    }

    /**
     * 设置操作人
     *
     * @param operate 操作人
     */
    public void setOperate(String operate) {
        this.operate = operate == null ? null : operate.trim();
    }
}