package com.ztwo.yeb.bean;

import java.util.Date;
import javax.persistence.*;

public class Joblevel {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 职称名称
     */
    private String name;

    /**
     * 职称等级
     */
    @Column(name = "titleLevel")
    private String titlelevel;

    /**
     * 创建时间
     */
    @Column(name = "createDate")
    private Date createdate;

    /**
     * 是否启用
     */
    private Boolean enabled;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取职称名称
     *
     * @return name - 职称名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置职称名称
     *
     * @param name 职称名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取职称等级
     *
     * @return titleLevel - 职称等级
     */
    public String getTitlelevel() {
        return titlelevel;
    }

    /**
     * 设置职称等级
     *
     * @param titlelevel 职称等级
     */
    public void setTitlelevel(String titlelevel) {
        this.titlelevel = titlelevel;
    }

    /**
     * 获取创建时间
     *
     * @return createDate - 创建时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置创建时间
     *
     * @param createdate 创建时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取是否启用
     *
     * @return enabled - 是否启用
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * 设置是否启用
     *
     * @param enabled 是否启用
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}