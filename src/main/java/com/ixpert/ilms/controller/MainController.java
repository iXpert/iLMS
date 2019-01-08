package com.ixpert.ilms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/", "/home"})
    public String showHome(){
        return "/home";
    }

    @GetMapping(value = "/books")
    public String showBooks(){
        return "/books";
    }

    @GetMapping(value = "/authors")
    public String showAuthors(){
        return "/authors";
    }

    @GetMapping(value = "/categories")
    public String showCategories(){
        return "/categories";
    }

    @GetMapping(value = "/newBook")
    public String showNewBook(){
        return "/newBook";
    }

    @GetMapping(value = "/newAuthor")
    public String showNewAuthor(){
        return "/newAuthor1";
    }

    @GetMapping(value = "/newCategory")
    public String showNewCategory(){
        return "/newCategory";
    }




}
