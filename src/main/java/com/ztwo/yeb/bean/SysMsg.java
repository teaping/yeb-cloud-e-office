package com.ztwo.yeb.bean;

import javax.persistence.*;

@Table(name = "sys_msg")
public class SysMsg {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 消息id
     */
    private Integer mid;

    /**
     * 0表示群发消息
     */
    private Integer type;

    /**
     * 这条消息是给谁的
     */
    private Integer adminid;

    /**
     * 0 未读 1 已读
     */
    private Integer state;

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
     * 获取消息id
     *
     * @return mid - 消息id
     */
    public Integer getMid() {
        return mid;
    }

    /**
     * 设置消息id
     *
     * @param mid 消息id
     */
    public void setMid(Integer mid) {
        this.mid = mid;
    }

    /**
     * 获取0表示群发消息
     *
     * @return type - 0表示群发消息
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置0表示群发消息
     *
     * @param type 0表示群发消息
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取这条消息是给谁的
     *
     * @return adminid - 这条消息是给谁的
     */
    public Integer getAdminid() {
        return adminid;
    }

    /**
     * 设置这条消息是给谁的
     *
     * @param adminid 这条消息是给谁的
     */
    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    /**
     * 获取0 未读 1 已读
     *
     * @return state - 0 未读 1 已读
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置0 未读 1 已读
     *
     * @param state 0 未读 1 已读
     */
    public void setState(Integer state) {
        this.state = state;
    }
}