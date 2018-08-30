package com.example.service;

import com.example.bean.primary.RUser;
import com.example.dao.primary.RUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/8/20 16:31
 * @Description:
 */
@Service
public class RUserService {
    @Autowired
    private RUserDao rUserDao;

    public List<RUser> list(){
        return rUserDao.findByAvailableTrueAndIdCardNoNotNullAndAgeNull();
    }
    public void update(Integer age,Long id){
        rUserDao.update(age,id);
    }
}
