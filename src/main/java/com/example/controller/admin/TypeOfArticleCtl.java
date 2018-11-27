package com.example.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.example.VO.LoginVO;
import com.example.bean.primary.Login;
import com.example.bean.second.TypeOfArticle;
import com.example.service.TypeOfArticleService;
import com.example.util.PropertyValueConstants;
import com.example.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping(value = "/admin/category/")
public class TypeOfArticleCtl {
    @Autowired
    private TypeOfArticleService typeOfArticleService;

    @RequestMapping(value = "list")
    public ModelAndView list(HttpServletRequest request, HttpSession session){
        ModelAndView view = new ModelAndView("/admin/typeArticle/category");
        List<TypeOfArticle> list = typeOfArticleService.findAll();
        view.addObject("list",list);
        return view;
    }
    @RequestMapping(value = "add")
    public ModelAndView list(HttpServletRequest request, TypeOfArticle typeOfArticle,BindingResult bingdingResult, HttpSession session){
        LoginVO vo = (LoginVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
        typeOfArticle.setCreateBy(vo.getName());
        typeOfArticleService.save(typeOfArticle);
        return new ModelAndView("redirect:/admin/category/list");
    }
    @RequestMapping(value = "delete/{categroyId}")
    @ResponseBody
    public ResponseWrapper delete(HttpServletRequest request, @PathVariable Integer categroyId, HttpSession session){
        LoginVO vo = (LoginVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
        TypeOfArticle typeOfArticle = typeOfArticleService.findById(categroyId);
        typeOfArticle.setChangeBy(vo.getName());
        return typeOfArticleService.delete(typeOfArticle);
    }
    @RequestMapping(value = "updataHtml/{categroyId}")
    public ModelAndView updataHtml(HttpServletRequest request, @PathVariable Integer categroyId,HttpSession session){
        TypeOfArticle typeOfArticle = typeOfArticleService.findById(categroyId);
        ModelAndView view = new ModelAndView("/admin/typeArticle/update-category");
        view.addObject("categroy",typeOfArticle);
        return view;
    }
    @RequestMapping(value = "update")
    @ResponseBody
    public ModelAndView updataHtml(HttpServletRequest request,TypeOfArticle type,BindingResult bingdingResult,HttpSession session){
        LoginVO vo = (LoginVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
        TypeOfArticle cate = typeOfArticleService.findById(type.getId());
        cate.setTypeName(type.getTypeName());
        cate.setTypeDesc(type.getTypeDesc());
        cate.setTypeAlias(type.getTypeAlias());
        cate.setChangeBy(vo.getName());
        boolean bool = typeOfArticleService.update(cate);
        if(bool){
            return new ModelAndView("redirect:/admin/category/list");
        }
        ModelAndView view = new ModelAndView("/admin/typeArticle/update-category");
        view.addObject("categroy",type);
        return view;
    }
}
