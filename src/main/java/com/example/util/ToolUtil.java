package com.example.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Copyright (C), 2015-2018
 * FileName: ToolUtil
 * Author:   wuxiaosen
 * Date:     2018/5/31 0031 9:40
 * Description: 工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Component
public class ToolUtil {

    public static String UUIDMethod(){
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
    public static String UUIDMethod(String str){
        byte bytes[] = str.getBytes();
        String uuid = UUID.nameUUIDFromBytes(bytes).toString();
        // 去掉"-"符号
        String temp = uuid.replaceAll("-","");
        return temp;
    }
}
