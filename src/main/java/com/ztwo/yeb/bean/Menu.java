package com.ztwo.yeb.bean;

import javax.persistence.*;

public class Menu {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * url
     */
    private String url;

    /**
     * path
     */
    private String path;

    /**
     * 组件
     */
    private String component;

    /**
     * 菜单名
     */
    private String name;

    /**
     * 图标
     */
    @Column(name = "iconCls")
    private String iconcls;

    /**
     * 是否保持激活
     */
    @Column(name = "keepAlive")
    private Boolean keepalive;

    /**
     * 是否要求权限
     */
    @Column(name = "requireAuth")
    private Boolean requireauth;

    /**
     * 父id
     */
    @Column(name = "parentId")
    private Integer parentid;

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
     * 获取url
     *
     * @return url - url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置url
     *
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取path
     *
     * @return path - path
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置path
     *
     * @param path path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取组件
     *
     * @return component - 组件
     */
    public String getComponent() {
        return component;
    }

    /**
     * 设置组件
     *
     * @param component 组件
     */
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * 获取菜单名
     *
     * @return name - 菜单名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名
     *
     * @param name 菜单名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取图标
     *
     * @return iconCls - 图标
     */
    public String getIconcls() {
        return iconcls;
    }

    /**
     * 设置图标
     *
     * @param iconcls 图标
     */
    public void setIconcls(String iconcls) {
        this.iconcls = iconcls;
    }

    /**
     * 获取是否保持激活
     *
     * @return keepAlive - 是否保持激活
     */
    public Boolean getKeepalive() {
        return keepalive;
    }

    /**
     * 设置是否保持激活
     *
     * @param keepalive 是否保持激活
     */
    public void setKeepalive(Boolean keepalive) {
        this.keepalive = keepalive;
    }

    /**
     * 获取是否要求权限
     *
     * @return requireAuth - 是否要求权限
     */
    public Boolean getRequireauth() {
        return requireauth;
    }

    /**
     * 设置是否要求权限
     *
     * @param requireauth 是否要求权限
     */
    public void setRequireauth(Boolean requireauth) {
        this.requireauth = requireauth;
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