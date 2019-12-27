package com.wwmust.manage.system.model;

public class ArticleDetail {
    private Long articleDetailId;

    private Integer approvalNum;

    private Integer opposeNum;

    private Integer collectNum;

    private Integer viewNum;

    private Integer attentionNum;

    private Long articleId;

    private String sysStarId;
    private String sysStarName;


    public String getSysStarId() {
        return sysStarId;
    }

    public void setSysStarId(String sysStarId) {
        this.sysStarId = sysStarId;
    }

    public String getSysStarName() {
        return sysStarName;
    }

    public void setSysStarName(String sysStarName) {
        this.sysStarName = sysStarName;
    }

    public Long getArticleDetailId() {
        return articleDetailId;
    }

    public void setArticleDetailId(Long articleDetailId) {
        this.articleDetailId = articleDetailId;
    }

    public Integer getApprovalNum() {
        return approvalNum;
    }

    public void setApprovalNum(Integer approvalNum) {
        this.approvalNum = approvalNum;
    }

    public Integer getOpposeNum() {
        return opposeNum;
    }

    public void setOpposeNum(Integer opposeNum) {
        this.opposeNum = opposeNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    public Integer getAttentionNum() {
        return attentionNum;
    }

    public void setAttentionNum(Integer attentionNum) {
        this.attentionNum = attentionNum;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}