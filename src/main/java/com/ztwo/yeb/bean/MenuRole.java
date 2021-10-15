package com.ztwo.yeb.bean;

import javax.persistence.*;

@Table(name = "menu_role")
public class MenuRole {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 菜单id
     */
    private Integer mid;

    /**
     * 权限id
     */
    private Integer rid;

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
     * 获取菜单id
     *
     * @return mid - 菜单id
     */
    public Integer getMid() {
        return mid;
    }

    /**
     * 设置菜单id
     *
     * @param mid 菜单id
     */
    public void setMid(Integer mid) {
        this.mid = mid;
    }

    /**
     * 获取权限id
     *
     * @return rid - 权限id
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * 设置权限id
     *
     * @param rid 权限id
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }
}