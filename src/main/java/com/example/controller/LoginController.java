package com.example.controller;

import com.example.VO.LoginVO;
import com.example.bean.primary.Login;
import com.example.service.LoginService;
import com.example.util.*;
import com.sun.org.apache.xml.internal.resolver.readers.TR9401CatalogReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    @RequestMapping(value = "/persion/resets")
    @ResponseBody
    public ResponseWrapper resets(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        Login login = loginService.findByAvailableIsAndNameIs(userName);
        if(login!=null){
            if(login.getEmail().equals(email)){
                //去设置新密码
                return ResponseWrapper.markSuccess(null);
            }else{
                return ResponseWrapper.markError();
            }
        }
        return ResponseWrapper.markUserNameError();
    }

    /**
     * 去重置密码
     * @return
     */
    @RequestMapping(value = "/persion/toResetPWD")
    public ModelAndView toResetPWD(HttpServletRequest request){
        String userName = request.getParameter("userName");
        ModelAndView view = new ModelAndView("/common/register");
        view.addObject("userName",userName);
        return view;
    }
    @RequestMapping(value = "/persion/resetPWD")
    @ResponseBody
    public ResponseWrapper resetPWD(HttpServletRequest request, HttpSession session){
        //用户登录，并发到session中
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("password");
        Login login = loginService.findByAvailableIsAndNameIs(userName);
        if(login!=null){
            String uuid = ToolUtil.UUIDMethod(passWord);
            login.setPassWord(uuid);
            boolean bool = loginService.update(login);
            if(bool){
                LoginVO vo = new LoginVO();
                vo.setId(login.getId());
                vo.setName(userName);
                session.setAttribute(PropertyValueConstants.SESSION_USER,vo);
                return ResponseWrapper.markPasswordUpdateSuccess();
            }else{
                return ResponseWrapper.markPasswordUpdateError();
            }
        }else {
            return ResponseWrapper.markUserNameError();
        }

    }
    /**
     * 注册
     * @return
     */
    @RequestMapping(value = "/persion/register")
    public ModelAndView register(){
        return new ModelAndView("/common/register");
    }

    /**
     * 去登陆
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "/persion/loginOut")
    @ResponseBody
    public ResponseWrapper loginOut(HttpServletRequest request, HttpSession session){
        //用户登录，并发到session中
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("password");
            Login login = loginService.findByAvailableIsAndNameIs(userName);
            if(login!=null){
                String md5 =  ToolUtil.UUIDMethod(passWord);
                if(login.getPassWord().equals(md5)){
                    LoginVO vo = new LoginVO();
                    vo.setId(login.getId());
                    vo.setName(userName);
                   //存到session中去
                    session.setAttribute(PropertyValueConstants.SESSION_USER,vo);
                   return ResponseWrapper.markUserSuccess();
                }else{
                    return ResponseWrapper.markPassWordError();
                }
            }else {
                return ResponseWrapper.markUserNameError();
            }

    }

}
