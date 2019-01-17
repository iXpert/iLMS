package com.ixpert.ilms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @GetMapping
    public ModelAndView showBooks(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test1");
        return modelAndView;
    }

}
