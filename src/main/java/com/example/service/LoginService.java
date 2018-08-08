package com.example.service;

import com.example.bean.primary.Login;
import com.example.bean.second.Girl;
import com.example.bean.second.IntegralOrder;
import com.example.bean.second.Product;
import com.example.dao.primary.LoginDao;
import com.example.dao.second.GirlDao;
import com.example.util.DateUtil;
import com.example.util.LogUtils;
import com.example.util.PropertyValueConstants;
import com.example.util.SpringContextUtil;
import com.example.util.thread.ProductThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Copyright (C), 2015-2018
 * FileName: LoginService
 * Author:   wuxiaosen
 * Date:     2018/5/17 0017 16:56
 * Description: 登陆操作service层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class LoginService {
    Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private LoginDao loginDao;
    @Autowired
    private GirlDao girlDao;

    public boolean save(Login login) {
        boolean fal = false;
        try {
            login.setAvailable(true);
            login.setVersion((short) 0);
            loginDao.save(login);
            fal = true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("---------Login表添加失败" + System.currentTimeMillis());
        }
        return fal;
    }

    public List<Girl> list() {
        List<Girl> list = girlDao.findAll();
        return list;
    }
    public Login findByAvailableIsAndNameIs(String userName){
       List<Login> list = loginDao.findByAvailableIsAndNameIs(PropertyValueConstants.AVAILABLE,userName);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }



    public String thread(Integer productId) {
        //查询
       new Thread(new ProductThread(1, productId, 3110)).start();
        return "线程";
    }
}