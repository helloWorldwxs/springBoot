package com.example.bean.second;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Copyright (C), 2015-2018
 * FileName: Girl
 * Author:   wuxiaosen
 * Date:     2018/7/6 0006 14:58
 * Description: 女生表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Entity
@Table(name = "girl")
public class Girl {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "age",length = 11)
    private Integer age;
    @Column(name = "cup_size",length = 255)
    private String cupSize;
    @Column(name = "name",length = 255)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
