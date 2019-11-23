package com.wwmust.manage.system.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "dic_eduction_backgroud")
public class dicEductionBackgroud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Short code;

    private Short 字典类型;

    private Short 是否有效;

    private Date 创建时间;

    private Date 更新时间;

    private String 创建人;

    private String 更新人;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return code
     */
    public Short getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(Short code) {
        this.code = code;
    }

    /**
     * @return 字典类型
     */
    public Short get字典类型() {
        return 字典类型;
    }

    /**
     * @param 字典类型
     */
    public void set字典类型(Short 字典类型) {
        this.字典类型 = 字典类型;
    }

    /**
     * @return 是否有效
     */
    public Short get是否有效() {
        return 是否有效;
    }

    /**
     * @param 是否有效
     */
    public void set是否有效(Short 是否有效) {
        this.是否有效 = 是否有效;
    }

    /**
     * @return 创建时间
     */
    public Date get创建时间() {
        return 创建时间;
    }

    /**
     * @param 创建时间
     */
    public void set创建时间(Date 创建时间) {
        this.创建时间 = 创建时间;
    }

    /**
     * @return 更新时间
     */
    public Date get更新时间() {
        return 更新时间;
    }

    /**
     * @param 更新时间
     */
    public void set更新时间(Date 更新时间) {
        this.更新时间 = 更新时间;
    }

    /**
     * @return 创建人
     */
    public String get创建人() {
        return 创建人;
    }

    /**
     * @param 创建人
     */
    public void set创建人(String 创建人) {
        this.创建人 = 创建人 == null ? null : 创建人.trim();
    }

    /**
     * @return 更新人
     */
    public String get更新人() {
        return 更新人;
    }

    /**
     * @param 更新人
     */
    public void set更新人(String 更新人) {
        this.更新人 = 更新人 == null ? null : 更新人.trim();
    }
}