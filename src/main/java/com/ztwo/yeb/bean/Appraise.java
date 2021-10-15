package com.ztwo.yeb.bean;

import java.util.Date;
import javax.persistence.*;

public class Appraise {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 员工id
     */
    private Integer eid;

    /**
     * 考评日期
     */
    @Column(name = "appDate")
    private Date appdate;

    /**
     * 考评结果
     */
    @Column(name = "appResult")
    private String appresult;

    /**
     * 考评内容
     */
    @Column(name = "appContent")
    private String appcontent;

    /**
     * 备注
     */
    private String remark;

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
     * 获取员工id
     *
     * @return eid - 员工id
     */
    public Integer getEid() {
        return eid;
    }

    /**
     * 设置员工id
     *
     * @param eid 员工id
     */
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /**
     * 获取考评日期
     *
     * @return appDate - 考评日期
     */
    public Date getAppdate() {
        return appdate;
    }

    /**
     * 设置考评日期
     *
     * @param appdate 考评日期
     */
    public void setAppdate(Date appdate) {
        this.appdate = appdate;
    }

    /**
     * 获取考评结果
     *
     * @return appResult - 考评结果
     */
    public String getAppresult() {
        return appresult;
    }

    /**
     * 设置考评结果
     *
     * @param appresult 考评结果
     */
    public void setAppresult(String appresult) {
        this.appresult = appresult;
    }

    /**
     * 获取考评内容
     *
     * @return appContent - 考评内容
     */
    public String getAppcontent() {
        return appcontent;
    }

    /**
     * 设置考评内容
     *
     * @param appcontent 考评内容
     */
    public void setAppcontent(String appcontent) {
        this.appcontent = appcontent;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}