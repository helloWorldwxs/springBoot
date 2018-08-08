package com.example.bean;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "integral_order")
public class IntegralOrder {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "integral")
    private Integer integral;
    @Column(name = "code")
    private String code;
    @Column(name = "state")
    private Integer state;
    @Column(name = "img_intrduce")
    private String imgIntrduce;
    @Column(name = "name")
    private String name;
    @Column(name = "content")
    private String content;
    @Column(name = "address")
    private String address;
    @Column(name = "created_time")
    private Date createdTime;
    @Column(name = "available")
    private Boolean available;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getIntegral() {
        return integral;
    }
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    public String getImgIntrduce() {
        return imgIntrduce;
    }
    public void setImgIntrduce(String imgIntrduce) {
        this.imgIntrduce = imgIntrduce == null ? null : imgIntrduce.trim();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
    public Date getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}