package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    /*@RequestMapping("/")
    public String testIndex(){
        return "index";
    }*/

    @RequestMapping("/test_view")
    public String test_view(){
        return "test_view";
    }
}
