package com.example.bean;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Copyright (C), 2015-2018
 * FileName: Product
 * Author:   wuxiaosen
 * Date:     2018/7/12 0012 16:50
 * Description: 商品表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @Column(name = "introduce")
    private String introduce;
    @Column(name = "img_intro")
    private String imgIntro;
    @Column(name = "img_banner")
    private String imgBanner;
    @Column(name = "price")
    private Integer price;
    @Column(name = "integral")
    private Integer integral;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "limit_num")
    private Integer limitNum;
    @Column(name = "down_time")
    private Date downTime;
    @Column(name = "available")
    private Boolean available;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "changed_at")
    private Date changedAt;
    @Column(name = "changed_by")
    private String changedBy;
    @Column(name = "version")
    private Integer version;

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }


    public String getIntroduce() {
        return introduce;
    }


    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }


    public String getImgIntro() {
        return imgIntro;
    }


    public void setImgIntro(String imgIntro) {
        this.imgIntro = imgIntro == null ? null : imgIntro.trim();
    }


    public String getImgBanner() {
        return imgBanner;
    }


    public void setImgBanner(String imgBanner) {
        this.imgBanner = imgBanner == null ? null : imgBanner.trim();
    }


    public Integer getPrice() {
        return price;
    }


    public void setPrice(Integer price) {
        this.price = price;
    }


    public Integer getIntegral() {
        return integral;
    }


    public void setIntegral(Integer integral) {
        this.integral = integral;
    }


    public Integer getStock() {
        return stock;
    }


    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getLimitNum() {
        return limitNum;
    }


    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }


    public Date getDownTime() {
        return downTime;
    }


    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }


    public Boolean getAvailable() {
        return available;
    }


    public void setAvailable(Boolean available) {
        this.available = available;
    }


    public Date getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public String getCreatedBy() {
        return createdBy;
    }


    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }


    public Date getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(Date changedAt) {
        this.changedAt = changedAt;
    }

    public String getChangedBy() {
        return changedBy;
    }


    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    public Integer getVersion() {
        return version;
    }


    public void setVersion(Integer version) {
        this.version = version;
    }
}


