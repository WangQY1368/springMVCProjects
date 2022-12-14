package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {

    //使用servletAPI向request域对象共享数据
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("testRequestScope", "hello,servletAPI");
        return "success";
    }

    //使用ModelAndView向request域对象共享数据
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        /*ModelAndView主要有Model和View功能
        * Model: 主要用于向请求域共享数据
        * View：主要用于设置视图，实现跳转*/
        ModelAndView mav = new ModelAndView();
        //处理模型数据,向请求域request共享数据
        mav.addObject("testRequestScope", "hello,servletAPI");
        //设置视图名称，实现跳转
        mav.setViewName("success");
        return mav;
    }

    //使用Model向request域对象共享数据
    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestScope", "hello,servletAPI");
        return "success";
    }

    //使用Map映射向request域对象共享数据
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        map.put("testRequestScope", "hello,servletAPI");
        return "success";
    }

    //使用ModelMap向request域对象共享数据
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope", "hello,ModelMap");
        return "success";
    }

    //向session域共享request数据
    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testRequestScope", "hello,ModelMap");
        return "success";
    }

    //向application域共享数据
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testRequestScope", "hello,ModelMap");
        return "success";
    }
}
