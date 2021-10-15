package com.ztwo.yeb.bean;

import java.util.Date;
import javax.persistence.*;

public class Oplog {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 添加日期
     */
    @Column(name = "addDate")
    private Date adddate;

    /**
     * 操作内容
     */
    private String operate;

    /**
     * 操作员ID
     */
    private Integer adminid;

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
     * 获取添加日期
     *
     * @return addDate - 添加日期
     */
    public Date getAdddate() {
        return adddate;
    }

    /**
     * 设置添加日期
     *
     * @param adddate 添加日期
     */
    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    /**
     * 获取操作内容
     *
     * @return operate - 操作内容
     */
    public String getOperate() {
        return operate;
    }

    /**
     * 设置操作内容
     *
     * @param operate 操作内容
     */
    public void setOperate(String operate) {
        this.operate = operate;
    }

    /**
     * 获取操作员ID
     *
     * @return adminid - 操作员ID
     */
    public Integer getAdminid() {
        return adminid;
    }

    /**
     * 设置操作员ID
     *
     * @param adminid 操作员ID
     */
    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }
}