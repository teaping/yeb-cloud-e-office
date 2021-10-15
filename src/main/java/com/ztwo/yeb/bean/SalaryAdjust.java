package com.ztwo.yeb.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "salary_adjust")
public class SalaryAdjust {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 员工ID
     */
    private Integer eid;

    /**
     * 调薪日期
     */
    @Column(name = "asDate")
    private Date asdate;

    /**
     * 调前薪资
     */
    @Column(name = "beforeSalary")
    private Integer beforesalary;

    /**
     * 调后薪资
     */
    @Column(name = "afterSalary")
    private Integer aftersalary;

    /**
     * 调薪原因
     */
    private String reason;

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
     * 获取员工ID
     *
     * @return eid - 员工ID
     */
    public Integer getEid() {
        return eid;
    }

    /**
     * 设置员工ID
     *
     * @param eid 员工ID
     */
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /**
     * 获取调薪日期
     *
     * @return asDate - 调薪日期
     */
    public Date getAsdate() {
        return asdate;
    }

    /**
     * 设置调薪日期
     *
     * @param asdate 调薪日期
     */
    public void setAsdate(Date asdate) {
        this.asdate = asdate;
    }

    /**
     * 获取调前薪资
     *
     * @return beforeSalary - 调前薪资
     */
    public Integer getBeforesalary() {
        return beforesalary;
    }

    /**
     * 设置调前薪资
     *
     * @param beforesalary 调前薪资
     */
    public void setBeforesalary(Integer beforesalary) {
        this.beforesalary = beforesalary;
    }

    /**
     * 获取调后薪资
     *
     * @return afterSalary - 调后薪资
     */
    public Integer getAftersalary() {
        return aftersalary;
    }

    /**
     * 设置调后薪资
     *
     * @param aftersalary 调后薪资
     */
    public void setAftersalary(Integer aftersalary) {
        this.aftersalary = aftersalary;
    }

    /**
     * 获取调薪原因
     *
     * @return reason - 调薪原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置调薪原因
     *
     * @param reason 调薪原因
     */
    public void setReason(String reason) {
        this.reason = reason;
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