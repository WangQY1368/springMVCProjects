package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    //1、Thymeleaf视图
    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        return  "success";
    }

    //2、转发视图 视图名称前缀为forward：时创建的是InternalResourceView
    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testThymeleafView";
    }

    //3、重定向视图
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testThymeleafView";
    }
}
