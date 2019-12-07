/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.facade.resp.article;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 12/07/2019 15:16
 */
public class ArticleSkinStypeResp {
    private Long articleSkinId;

    private String templeteImg;

    private String isDefault;

    private String barColor;

    private String color;

    private String topColor;

    private String bottomColor;


    public Long getArticleSkinId() {
        return articleSkinId;
    }

    public void setArticleSkinId(Long articleSkinId) {
        this.articleSkinId = articleSkinId;
    }

    public String getTempleteImg() {
        return templeteImg;
    }

    public void setTempleteImg(String templeteImg) {
        this.templeteImg = templeteImg;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getBarColor() {
        return barColor;
    }

    public void setBarColor(String barColor) {
        this.barColor = barColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTopColor() {
        return topColor;
    }

    public void setTopColor(String topColor) {
        this.topColor = topColor;
    }

    public String getBottomColor() {
        return bottomColor;
    }

    public void setBottomColor(String bottomColor) {
        this.bottomColor = bottomColor;
    }
}
