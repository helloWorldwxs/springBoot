package com.example.controller.admin;

import com.example.bean.second.TypeOfArticle;
import com.example.service.TypeOfArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/8/30 17:19
 * @Description:
 */
@Controller
@RequestMapping(value = "/admin/type/")
public class TypeOfArticleCtl {
    @Autowired
    private TypeOfArticleService typeOfArticleService;

    @RequestMapping(value = "list")
    public ModelAndView list(HttpServletRequest request, HttpSession session){
        ModelAndView view = new ModelAndView("/admin/typeArticle/list");
        List<TypeOfArticle> list = typeOfArticleService.findAll();
        view.addObject("list",list);
        return view;
    }

}
