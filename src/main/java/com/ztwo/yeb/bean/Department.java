package com.ztwo.yeb.bean;

import javax.persistence.*;

public class Department {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 父id
     */
    @Column(name = "parentId")
    private Integer parentid;

    /**
     * 路径
     */
    @Column(name = "depPath")
    private String deppath;

    /**
     * 是否启用
     */
    private Boolean enabled;

    /**
     * 是否上级
     */
    @Column(name = "isParent")
    private Boolean isparent;

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
     * 获取部门名称
     *
     * @return name - 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部门名称
     *
     * @param name 部门名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取父id
     *
     * @return parentId - 父id
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * 设置父id
     *
     * @param parentid 父id
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * 获取路径
     *
     * @return depPath - 路径
     */
    public String getDeppath() {
        return deppath;
    }

    /**
     * 设置路径
     *
     * @param deppath 路径
     */
    public void setDeppath(String deppath) {
        this.deppath = deppath;
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

    /**
     * 获取是否上级
     *
     * @return isParent - 是否上级
     */
    public Boolean getIsparent() {
        return isparent;
    }

    /**
     * 设置是否上级
     *
     * @param isparent 是否上级
     */
    public void setIsparent(Boolean isparent) {
        this.isparent = isparent;
    }
}