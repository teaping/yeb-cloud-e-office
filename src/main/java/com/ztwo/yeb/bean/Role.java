package com.ztwo.yeb.bean;

import javax.persistence.*;

public class Role {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 角色名称
     */
    @Column(name = "nameZh")
    private String namezh;

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
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取角色名称
     *
     * @return nameZh - 角色名称
     */
    public String getNamezh() {
        return namezh;
    }

    /**
     * 设置角色名称
     *
     * @param namezh 角色名称
     */
    public void setNamezh(String namezh) {
        this.namezh = namezh;
    }
}