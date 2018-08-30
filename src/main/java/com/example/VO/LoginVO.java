package com.example.VO;

/**
 * @Auther: Administrator
 * @Date: 2018/8/30 10:06
 * @Description:
 */
public class LoginVO {
    private Integer id;
    private String name;

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
        this.name = name;
    }

    public LoginVO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public LoginVO() {
    }
}
