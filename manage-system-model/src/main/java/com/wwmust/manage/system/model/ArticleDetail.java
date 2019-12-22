package com.wwmust.manage.system.model;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "article_detail")
public class ArticleDetail {
    @Column(name = "article_detail_id")
    private Long articleDetailId;

    /**
     * 赞同数
     */
    @Column(name = "approval_num")
    private Integer approvalNum;

    @Column(name = "oppose_num")
    private Integer opposeNum;

    /**
     * 收藏数
     */
    @Column(name = "collect_num")
    private Integer collectNum;

    /**
     * 浏览数
     */
    @Column(name = "view_num")
    private Integer viewNum;

    /**
     * 关注数
     */
    @Column(name = "attention_num")
    private Integer attentionNum;

    /**
     * 文章id
     */
    @Column(name = "article_id")
    private Long articleId;

    /**
     * @return article_detail_id
     */
    public Long getArticleDetailId() {
        return articleDetailId;
    }

    /**
     * @param articleDetailId
     */
    public void setArticleDetailId(Long articleDetailId) {
        this.articleDetailId = articleDetailId;
    }

    /**
     * 获取赞同数
     *
     * @return approval_num - 赞同数
     */
    public Integer getApprovalNum() {
        return approvalNum;
    }

    /**
     * 设置赞同数
     *
     * @param approvalNum 赞同数
     */
    public void setApprovalNum(Integer approvalNum) {
        this.approvalNum = approvalNum;
    }

    /**
     * @return oppose_num
     */
    public Integer getOpposeNum() {
        return opposeNum;
    }

    /**
     * @param opposeNum
     */
    public void setOpposeNum(Integer opposeNum) {
        this.opposeNum = opposeNum;
    }

    /**
     * 获取收藏数
     *
     * @return collect_num - 收藏数
     */
    public Integer getCollectNum() {
        return collectNum;
    }

    /**
     * 设置收藏数
     *
     * @param collectNum 收藏数
     */
    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    /**
     * 获取浏览数
     *
     * @return view_num - 浏览数
     */
    public Integer getViewNum() {
        return viewNum;
    }

    /**
     * 设置浏览数
     *
     * @param viewNum 浏览数
     */
    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    /**
     * 获取关注数
     *
     * @return attention_num - 关注数
     */
    public Integer getAttentionNum() {
        return attentionNum;
    }

    /**
     * 设置关注数
     *
     * @param attentionNum 关注数
     */
    public void setAttentionNum(Integer attentionNum) {
        this.attentionNum = attentionNum;
    }

    /**
     * 获取文章id
     *
     * @return article_id - 文章id
     */
    public Long getArticleId() {
        return articleId;
    }

    /**
     * 设置文章id
     *
     * @param articleId 文章id
     */
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}