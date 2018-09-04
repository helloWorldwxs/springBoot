package com.example.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: Administrator
 * @Date: 2018/8/30 17:48
 * @Description:
 */
@Controller
@RequestMapping(value = "/admin/")
public class IndexCtl {
    @RequestMapping(value = "index")
    public ModelAndView index(){
        return new ModelAndView("/admin/index");
    }
}
