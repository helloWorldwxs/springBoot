package com.example.util;

/**
 * Copyright (C), 2015-2018
 * FileName: LogEum
 * Author:   wuxiaosen
 * Date:     2018/7/5 0005 18:38
 * Description:平台日志（${project.name}_platform.log）、 业务日志（${project.name}_bussiness.log）、
 * 错误日志（${project.name}_exception.log）、DB 日志（${project.name}_db.log）
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public enum  LogEnum {

    BUSSINESS("bussiness"),
    PLATFORM("platform"),
    DB("db"),
    EXCEPTION("exception");
    private String category;


    LogEnum(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    ;

}
