package com.ztwo.yeb.bean;

import javax.persistence.*;

public class Nation {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 民族
     */
    private String name;

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
     * 获取民族
     *
     * @return name - 民族
     */
    public String getName() {
        return name;
    }

    /**
     * 设置民族
     *
     * @param name 民族
     */
    public void setName(String name) {
        this.name = name;
    }
}