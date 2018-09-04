package com.example.service;

import com.example.bean.second.Article;
import com.example.dao.second.ArticleDao;
import com.example.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/9/4 10:10
 * @Description:
 */
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;
    private final Logger logger = LoggerFactory.getLogger(ArticleService.class);

    public boolean save(Article article){
        boolean bool = false;
        try {
            article.setAvailable(PropertyValueConstants.AVAILABLE);
            article.setVersion(0);
            article.setCreatedAt(new Date());
            articleDao.save(article);
        }catch (Exception e){
            e.printStackTrace();
            String error = "添加文章失败！时间："+DateUtil.getCurrentFormatDatem(new Date())+"内容是："+article.toString();
            logger.error(error);
            Logger log =  LogUtils.getExceptionLogger();
            log.error(error);
        }
        return bool;
    }
    public boolean update(Article article){
        boolean bool = false;
        try {
            article.setVersion(article.getVersion()+1);
            article.setChangedAt(new Date());
            articleDao.save(article);
        }catch (Exception e){
            e.printStackTrace();
            String error = "修改文章失败！时间："+DateUtil.getCurrentFormatDatem(new Date())+"内容是："+article.toString();
            logger.error(error);
            Logger log =  LogUtils.getExceptionLogger();
            log.error(error);
        }
        return bool;
    }
    public ResponseWrapper delete(Article article){
        try {
            article.setVersion(article.getVersion()+1);
            article.setChangedAt(new Date());
            article.setAvailable(PropertyValueConstants.UNAVAILABLE);
            articleDao.saveAndFlush(article);
            return ResponseWrapper.markCustom(true,ReturnCode.DELETESUCCESS.getCode(),ReturnCode.DELETESUCCESS.getMsg(),null);
        }catch (Exception e){
            e.printStackTrace();
            String error = "删除文章失败！时间："+DateUtil.getCurrentFormatDatem(new Date())+"内容是："+article.toString();
            logger.error(error);
            Logger log =  LogUtils.getExceptionLogger();
            log.error(error);
            return ResponseWrapper.markCustom(true,ReturnCode.DELETEERROR.getCode(),ReturnCode.DELETEERROR.getMsg(),null);
        }
    }
    public PageInfo<Article> list(int page,int num){
         PageHelper.startPage(page,num);
         List<Article> list = articleDao.findByAvailableTrueAndOrderByCreatedAt();
         return new PageInfo<Article>(list);
    }
}
