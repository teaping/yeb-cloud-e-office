package com.ztwo.yeb.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mail_log")
public class MailLog {
    /**
     * 消息id
     */
    @Column(name = "msgId")
    private String msgid;

    /**
     * 接收员工id
     */
    private Integer eid;

    /**
     * 状态（0:消息投递中 1:投递成功 2:投递失败）
     */
    private Integer status;

    /**
     * 路由键
     */
    @Column(name = "routeKey")
    private String routekey;

    /**
     * 交换机
     */
    private String exchange;

    /**
     * 重试次数
     */
    private Integer count;

    /**
     * 重试时间
     */
    @Column(name = "tryTime")
    private Date trytime;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 更新时间
     */
    @Column(name = "updateTime")
    private Date updatetime;

    /**
     * 获取消息id
     *
     * @return msgId - 消息id
     */
    public String getMsgid() {
        return msgid;
    }

    /**
     * 设置消息id
     *
     * @param msgid 消息id
     */
    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    /**
     * 获取接收员工id
     *
     * @return eid - 接收员工id
     */
    public Integer getEid() {
        return eid;
    }

    /**
     * 设置接收员工id
     *
     * @param eid 接收员工id
     */
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /**
     * 获取状态（0:消息投递中 1:投递成功 2:投递失败）
     *
     * @return status - 状态（0:消息投递中 1:投递成功 2:投递失败）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态（0:消息投递中 1:投递成功 2:投递失败）
     *
     * @param status 状态（0:消息投递中 1:投递成功 2:投递失败）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取路由键
     *
     * @return routeKey - 路由键
     */
    public String getRoutekey() {
        return routekey;
    }

    /**
     * 设置路由键
     *
     * @param routekey 路由键
     */
    public void setRoutekey(String routekey) {
        this.routekey = routekey;
    }

    /**
     * 获取交换机
     *
     * @return exchange - 交换机
     */
    public String getExchange() {
        return exchange;
    }

    /**
     * 设置交换机
     *
     * @param exchange 交换机
     */
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    /**
     * 获取重试次数
     *
     * @return count - 重试次数
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置重试次数
     *
     * @param count 重试次数
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取重试时间
     *
     * @return tryTime - 重试时间
     */
    public Date getTrytime() {
        return trytime;
    }

    /**
     * 设置重试时间
     *
     * @param trytime 重试时间
     */
    public void setTrytime(Date trytime) {
        this.trytime = trytime;
    }

    /**
     * 获取创建时间
     *
     * @return createTime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更新时间
     *
     * @return updateTime - 更新时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间
     *
     * @param updatetime 更新时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}