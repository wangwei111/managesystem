package com.wwmust.manage.system.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class User {
    @Id
    private Integer uid;

    private String anonymity;

    private String username;

    @Column(name = "account_number")
    private String accountNumber;

    private String password;

    private String email;

    private String address;

    @Column(name = "img_url")
    private String imgUrl;

    private Integer region;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "emotion_status")
    private String emotionStatus;

    @Column(name = "eduction_backgroud")
    private String eductionBackgroud;

    private String school;

    @Column(name = "weChat_id")
    private String wechatId;

    @Column(name = "is_valid")
    private String isValid;

    @Column(name = "careta_date")
    private Date caretaDate;

    @Column(name = "update_date")
    private Date updateDate;

    /**
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * @return anonymity
     */
    public String getAnonymity() {
        return anonymity;
    }

    /**
     * @param anonymity
     */
    public void setAnonymity(String anonymity) {
        this.anonymity = anonymity == null ? null : anonymity.trim();
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return account_number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber == null ? null : accountNumber.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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
     * @return region
     */
    public Integer getRegion() {
        return region;
    }

    /**
     * @param region
     */
    public void setRegion(Integer region) {
        this.region = region;
    }

    /**
     * @return phone_number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * @return emotion_status
     */
    public String getEmotionStatus() {
        return emotionStatus;
    }

    /**
     * @param emotionStatus
     */
    public void setEmotionStatus(String emotionStatus) {
        this.emotionStatus = emotionStatus == null ? null : emotionStatus.trim();
    }

    /**
     * @return eduction_backgroud
     */
    public String getEductionBackgroud() {
        return eductionBackgroud;
    }

    /**
     * @param eductionBackgroud
     */
    public void setEductionBackgroud(String eductionBackgroud) {
        this.eductionBackgroud = eductionBackgroud == null ? null : eductionBackgroud.trim();
    }

    /**
     * @return school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school
     */
    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    /**
     * @return weChat_id
     */
    public String getWechatId() {
        return wechatId;
    }

    /**
     * @param wechatId
     */
    public void setWechatId(String wechatId) {
        this.wechatId = wechatId == null ? null : wechatId.trim();
    }

    /**
     * @return is_valid
     */
    public String getIsValid() {
        return isValid;
    }

    /**
     * @param isValid
     */
    public void setIsValid(String isValid) {
        this.isValid = isValid == null ? null : isValid.trim();
    }

    /**
     * @return careta_date
     */
    public Date getCaretaDate() {
        return caretaDate;
    }

    /**
     * @param caretaDate
     */
    public void setCaretaDate(Date caretaDate) {
        this.caretaDate = caretaDate;
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
}