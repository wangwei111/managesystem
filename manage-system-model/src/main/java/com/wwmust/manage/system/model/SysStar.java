package com.wwmust.manage.system.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_star")
public class SysStar {
    @Id
    @Column(name = "sys_star_id")
    private Long sysStarId;

    @Column(name = "star_name")
    private String starName;

    @Column(name = "enable_flag")
    private String enableFlag;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    private Integer sort;

    /**
     * @return sys_star_id
     */
    public Long getSysStarId() {
        return sysStarId;
    }

    /**
     * @param sysStarId
     */
    public void setSysStarId(Long sysStarId) {
        this.sysStarId = sysStarId;
    }

    /**
     * @return star_name
     */
    public String getStarName() {
        return starName;
    }

    /**
     * @param starName
     */
    public void setStarName(String starName) {
        this.starName = starName == null ? null : starName.trim();
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
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}