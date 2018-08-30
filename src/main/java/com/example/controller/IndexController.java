package com.example.controller;

import com.example.bean.primary.Login;
import com.example.bean.primary.RUser;
import com.example.bean.second.Girl;
import com.example.service.LoginService;
import com.example.service.RUserService;
import com.example.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {

    Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping(value = "/index")
    @ResponseBody
    public String index(){
       String name = "wxs";
        Login login = new Login();
        login.setName(name);
        login.setPassWord("123456");
        Boolean fal = loginService.save(login);
        String uuid = ToolUtil.UUIDMethod();
        Long time =Long.valueOf("12000");
        boolean fals = redisUtil.set(uuid,name,time);
        logger.info( " debug "+ name + fals);
        logger.info( " error " + fal );
        Logger log = LogUtils.getExceptionLogger();
        Logger log1 = LogUtils.getBussinessLogger();
        Logger log2 = LogUtils.getDBLogger();
        log.error("getExceptionLogger===日志测试");
        log1.info("getBussinessLogger===日志测试");
        log2.debug("getDBLogger===日志测试");
        return "hello world";
    }
    @RequestMapping(value = "list")
    public ResponseWrapper list(){
        List<Girl> list = loginService.list();
        return ResponseWrapper.markSuccess(list);
    }
    @RequestMapping(value = "productThread")
    public ResponseWrapper productThread(Integer productId){
        String result = "";
        for (int i = 0;i<1;i++){
            result = loginService.thread(productId);
            result += result;
        }
        return ResponseWrapper.markSuccess(result);
    }

    @Autowired
    private RUserService rUserService;

    @RequestMapping(value = "user")
    public void demo(){
        List<RUser> list = rUserService.list();
        for  (int i = 0; i<list.size();i++){
            RUser user = list.get(i);
            if(user!=null){
                String idCard = user.getIdCardNo().trim();
                String ageStr = user.getBirthday().toString();
                if(idCard!=null&&(idCard.length()>=10)){
                    //411328199410287771
                    String shengRi = idCard.substring(6,10);
                    Integer sheng = Integer.valueOf(shengRi);
                    Integer date = Integer.valueOf("2018");
                    Integer cha = (date - sheng) + 1;
                    user.setAge(cha);
                    rUserService.update(cha,user.getId());
                }else if(ageStr!=null&&ageStr.length()>0){
                    String shengRi = ageStr.substring(0,3);
                    Integer sheng = Integer.valueOf(shengRi);
                    Integer date = Integer.valueOf("2018");
                    Integer cha = (date - sheng) + 1;
                    user.setAge(cha);
                    rUserService.update(cha,user.getId());
                }
            }
        }
    }
}
