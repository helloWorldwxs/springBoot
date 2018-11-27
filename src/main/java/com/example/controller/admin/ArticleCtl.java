package com.example.controller.admin;

import com.example.VO.LoginVO;
import com.example.bean.second.Article;
import com.example.service.ArticleService;
import com.example.service.TypeOfArticleService;
import com.example.util.PropertyValueConstants;
import com.example.util.ResponseWrapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Auther: Administrator
 * @Date: 2018/9/4 15:34
 * @Description:
 */
@Controller
@RequestMapping(value = "/admin/article/")
public class ArticleCtl {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TypeOfArticleService typeOfArticleService;

    @RequestMapping(value = "list")
    public ModelAndView list(@RequestParam(value = "pageSize",defaultValue = "1")int pageSize,
                             @RequestParam(value = "num",defaultValue = "10") int num, HttpSession session){
       PageInfo<Article> page = articleService.list(pageSize,num);
       ModelAndView view = new ModelAndView("admin/article/list");
       view.addObject("page",page);
       view.addObject("catagory",typeOfArticleService.findAll());
       return view;
    }
    @RequestMapping(value = "delete/{id}")
    @ResponseBody
    public ResponseWrapper delete(@PathVariable("id")Integer id,HttpSession session){
        LoginVO vo = (LoginVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
        Article article = articleService.findById(id);
        article.setChangedBy(vo.getName());
        return articleService.delete(article);
    }
    @RequestMapping(value = "updateHtml/{id}")
    public ModelAndView updateHtml(HttpSession session,@PathVariable("id")Integer id){
        Article article = articleService.findById(id);
        ModelAndView view = new ModelAndView("/admin/article/update-article");
        view.addObject("article",article);
        return view;
    }
    @RequestMapping(value = "update")
    public ModelAndView updata(HttpSession session,Article article){
        LoginVO vo = (LoginVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
        article.setChangedBy(vo.getName());
        boolean bool = articleService.update(article);
        if(bool){
            return new ModelAndView("redirect:/admin/article/list");
        }
        ModelAndView view = new ModelAndView("/admin/article/update-article");
        view.addObject("article",article);
        view.addObject("catagory",typeOfArticleService.findAll());
        return view;
    }
    @RequestMapping(value = "saveHtml")
    public ModelAndView saveHtml(HttpSession session){
        ModelAndView view = new ModelAndView("/admin/article/add-article");
        view.addObject("catagory",typeOfArticleService.findAll());
        return view;
    }
    @RequestMapping(value = "save")
    public ModelAndView save(HttpSession session,Article article){
        LoginVO vo = (LoginVO) session.getAttribute(PropertyValueConstants.SESSION_USER);
        article.setCreatedBy(vo.getName());
        boolean bool = articleService.save(article);
        if(bool){
            return new ModelAndView("redirect:/admin/article/list");
        }
        ModelAndView view = new ModelAndView("/admin/article/add-article");
        view.addObject("article",article);
        return view;
    }
}
