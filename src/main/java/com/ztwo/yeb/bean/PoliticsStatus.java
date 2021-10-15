package com.ztwo.yeb.bean;

import javax.persistence.*;

@Table(name = "politics_status")
public class PoliticsStatus {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 政治面貌
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
     * 获取政治面貌
     *
     * @return name - 政治面貌
     */
    public String getName() {
        return name;
    }

    /**
     * 设置政治面貌
     *
     * @param name 政治面貌
     */
    public void setName(String name) {
        this.name = name;
    }
}