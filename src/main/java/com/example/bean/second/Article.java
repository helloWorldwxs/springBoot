package com.example.bean.second;

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
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "keyword")
    private String keyword;
    @Column(name = "describe")
    private String describe;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
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

    public Article() {}

    public Article(String title, String content, String keyword, String describe, Boolean available, Date createdAt, String createdBy, Date changedAt, String changedBy, Integer version) {
        this.title = title;
        this.content = content;
        this.keyword = keyword;
        this.describe = describe;
        this.available = available;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.changedAt = changedAt;
        this.changedBy = changedBy;
        this.version = version;
    }
    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", keyword='" + keyword + '\'' +
                ", describe='" + describe + '\'' +
                ", available=" + available +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", changedAt=" + changedAt +
                ", changedBy='" + changedBy + '\'' +
                ", version=" + version +
                '}';
    }
}


