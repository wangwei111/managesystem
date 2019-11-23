package com.wwmust.manage.system.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bs_draft")
public class bsDraft {
    @Id
    @Column(name = "draft_id")
    private Long draftId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "draft_name")
    private String draftName;

    @Column(name = "is_nack_name")
    private Short isNackName;

    private String region;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "is_valid")
    private Short isValid;

    private String chapter;

    private String section;

    @Column(name = "draft_content")
    private String draftContent;

    /**
     * @return draft_id
     */
    public Long getDraftId() {
        return draftId;
    }

    /**
     * @param draftId
     */
    public void setDraftId(Long draftId) {
        this.draftId = draftId;
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
     * @return draft_name
     */
    public String getDraftName() {
        return draftName;
    }

    /**
     * @param draftName
     */
    public void setDraftName(String draftName) {
        this.draftName = draftName == null ? null : draftName.trim();
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
     * @return chapter
     */
    public String getChapter() {
        return chapter;
    }

    /**
     * @param chapter
     */
    public void setChapter(String chapter) {
        this.chapter = chapter == null ? null : chapter.trim();
    }

    /**
     * @return section
     */
    public String getSection() {
        return section;
    }

    /**
     * @param section
     */
    public void setSection(String section) {
        this.section = section == null ? null : section.trim();
    }

    /**
     * @return draft_content
     */
    public String getDraftContent() {
        return draftContent;
    }

    /**
     * @param draftContent
     */
    public void setDraftContent(String draftContent) {
        this.draftContent = draftContent == null ? null : draftContent.trim();
    }
}