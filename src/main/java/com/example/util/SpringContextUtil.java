package com.example.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.applet.AppletContext;

/**
 * Copyright (C), 2015-2018
 * FileName: SpringContextUtil
 * Author:   wuxiaosen
 * Date:     2018/7/13 0013 11:34
 * Description: 获取上下文所有bean
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Component
public class SpringContextUtil implements ApplicationContextAware{

    // Spring应用上下文环境
    private static ApplicationContext applicationContext;
    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    /**
     * 获取对象 这里重写了bean方法，起主要作用
     * example: getBean("userService")//注意： 类名首字母一定要小写！
     */
    public static Object getBean(String beanId) throws BeansException {
        return applicationContext.getBean(beanId);
    }

}
