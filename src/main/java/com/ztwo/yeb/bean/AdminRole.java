package com.ztwo.yeb.bean;

import javax.persistence.*;

@Table(name = "admin_role")
public class AdminRole {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "adminId")
    private Integer adminid;

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
     * 获取用户id
     *
     * @return adminId - 用户id
     */
    public Integer getAdminid() {
        return adminid;
    }

    /**
     * 设置用户id
     *
     * @param adminid 用户id
     */
    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
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