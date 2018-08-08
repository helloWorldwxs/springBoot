package com.example.controller;

import com.example.bean.primary.Login;
import com.example.service.LoginService;
import com.example.util.DateUtil;
import com.example.util.RedisUtil;
import com.example.util.ResponseWrapper;
import com.example.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Copyright (C), 2015-2018
 * FileName: LoginController
 * Author:   wuxiaosen
 * Date:     2018/7/13 0013 15:56
 * Description: 登录
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisUtil redisUtil;
    /**
     * 进入登录页面
     * @return
     */
    @RequestMapping(value = " ")
    public ModelAndView logins(){
        return new ModelAndView("/common/login");
    }
    @RequestMapping(value = "/")
    public ModelAndView loginse(){
        return new ModelAndView("/common/login");
    }
    @RequestMapping(value = "/persion/login")
    public ModelAndView login(){
        return new ModelAndView("/common/login");
    }

    /**
     * 重置密码
     * @return
     */
    @RequestMapping(value = "/persion/reset")
    public ModelAndView reset(){
        return new ModelAndView("/common/reset");
    }

    /**
     * 注册
     * @return
     */
    @RequestMapping(value = "/persion/register")
    public ModelAndView register(){
        return new ModelAndView("/common/register");
    }
    @RequestMapping(value = "/persion/loginOut")
    @ResponseBody
    public ResponseWrapper loginOut(HttpServletRequest request){
        //用户登录，并发到session中
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("password");
        Login login = loginService.findByAvailableIsAndNameIs(userName);
        if(login!=null){
            //String md5 =  ToolUtil.UUIDMethod(passWord);
            if(login.getPassWord().equals(passWord)){
                //存到redis中,先查询，如果有，就删除，重新登录 默认时间是30分钟
                String value = redisUtil.get(userName);
                if(value!=null&&value.length()>0){
                    redisUtil.remove(userName);
                }
                Long time =Long.valueOf("1800000");
                String dateStr = DateUtil.formatDate(new Date(),"YYYY-MM-dd HH;mm:ss");
                redisUtil.set(userName,dateStr,time);
               return ResponseWrapper.markUserSuccess();
            }else{
                return ResponseWrapper.markPassWordError();
            }
        }else {
            return ResponseWrapper.markUserNameError();
        }
    }

}
