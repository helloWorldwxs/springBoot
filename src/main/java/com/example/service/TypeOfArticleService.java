package com.example.service;

import com.example.bean.second.TypeOfArticle;
import com.example.dao.second.TypeOfArticleDao;
import com.example.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/8/30 16:41
 * @Description:
 */
@Service
public class TypeOfArticleService {
    private final Logger logger = LoggerFactory.getLogger(TypeOfArticleService.class);
    @Autowired
    private TypeOfArticleDao typeOfArticleDao;

    public boolean save(TypeOfArticle typeOfArticle){
        boolean fal = false;
        try {
            typeOfArticle.setCreateAt(new Date());
            typeOfArticle.setAvailabe(PropertyValueConstants.AVAILABLE);
            typeOfArticle.setTypeCount(0);
            typeOfArticleDao.save(typeOfArticle);
            fal = true;
        }catch (Exception e){
            e.printStackTrace();
            String error = "添加文章类型失败！时间："+DateUtil.getCurrentFormatDatem(new Date())+"内容是："+typeOfArticle.toString();
            logger.error(error);
            Logger log =  LogUtils.getExceptionLogger();
            log.error(error);
        }
        return fal;
    }
    public boolean update(TypeOfArticle typeOfArticle){
        boolean fal = false;
        try {
            short version = (short) (typeOfArticle.getVersion() + (short)1);
            typeOfArticle.setVersion(version);
            typeOfArticle.setChangeAt(new Date());
            typeOfArticleDao.saveAndFlush(typeOfArticle);
            fal = true;
        }catch (Exception e){
            e.printStackTrace();
            String error = "修改文章类型失败！时间："+DateUtil.getCurrentFormatDatem(new Date())+"内容是："+typeOfArticle.toString();
            logger.error(error);
            Logger log =  LogUtils.getExceptionLogger();
            log.error(error);
        }
        return fal;
    }
    public ResponseWrapper delete(TypeOfArticle typeOfArticle){
        try {
            short version = (short) (typeOfArticle.getVersion() + (short)1);
            typeOfArticle.setVersion(version);
            typeOfArticle.setChangeAt(new Date());
            typeOfArticle.setAvailabe(PropertyValueConstants.UNAVAILABLE);
            typeOfArticleDao.saveAndFlush(typeOfArticle);
            return ResponseWrapper.markCustom(true,ReturnCode.DELETESUCCESS.getCode(),ReturnCode.DELETESUCCESS.getMsg(),null);
        }catch (Exception e){
            e.printStackTrace();
            String error = "修改文章类型失败！时间："+DateUtil.getCurrentFormatDatem(new Date())+"内容是："+typeOfArticle.toString();
            logger.error(error);
            Logger log =  LogUtils.getExceptionLogger();
            log.error(error);
            return ResponseWrapper.markCustom(true,ReturnCode.DELETEERROR.getCode(),ReturnCode.DELETEERROR.getMsg(),null);
        }
    }
    public List<TypeOfArticle> findAll(){
       List<TypeOfArticle> list = typeOfArticleDao.findByAvailabeIsTrue();
       return list;
    }
    public TypeOfArticle findById(Integer id){
        return typeOfArticleDao.findByIdEquals(id);
    }
}
