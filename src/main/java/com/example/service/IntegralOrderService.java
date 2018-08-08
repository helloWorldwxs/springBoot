package com.example.service;

import com.example.bean.second.IntegralOrder;
import com.example.dao.second.IntergralOrderDao;
import com.example.util.DateUtil;
import com.example.util.LogUtils;
import com.example.util.PropertyValueConstants;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.PropertyPermission;

/**
 * Copyright (C), 2015-2018
 * FileName: IntegralOrder
 * Author:   wuxiaosen
 * Date:     2018/7/12 0012 17:46
 * Description: 订单业务层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class IntegralOrderService {
    @Autowired
    public IntergralOrderDao integralOrderDao;

    public Boolean add(IntegralOrder integralOrder){
        try {
            integralOrder.setAvailable(PropertyValueConstants.AVAILABLE);
            integralOrder.setCreatedTime(new Date());
            integralOrderDao.save(integralOrder);
            return true;
        }catch (Exception e){
            Logger log = LogUtils.getBussinessLogger();
            log.info("添加订单失败！"+ DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
            return false;
        }

    }
}
