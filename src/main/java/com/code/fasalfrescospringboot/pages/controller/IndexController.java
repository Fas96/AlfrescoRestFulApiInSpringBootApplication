package com.code.fasalfrescospringboot.pages.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {


    @GetMapping("/")
    public  ModelAndView init(ModelAndView modelAndView){
        modelAndView.addObject("message","Hi fas");
        modelAndView.setViewName("site-index");
        return modelAndView;
    }
}
