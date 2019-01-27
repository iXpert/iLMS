package com.ixpert.ilms.controller;

import com.ixpert.ilms.model.Author;
import com.ixpert.ilms.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ModelAndView showAllAuthors(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allAuthors",authorService.getAllAuthors());
        modelAndView.setViewName("authors");
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(Author author){
        System.out.println("\n");
        System.out.println("\n ------------------------- Inside AuthorController.save -------------------------");
        System.out.println("\n");
        authorService.saveAuthor(author);
        return "redirect:/author";

    }

    @GetMapping(value = "/delete")
    public String delete(Integer id){
        System.out.println("\n");
        System.out.println("\n ------------------------- Inside AuthorController.delete -------------------------");
        System.out.println("\n");
        authorService.deleteAuthorById(id);
        return "redirect:/author";
    }

    @GetMapping(value = "/new")
    public ModelAndView newAuthor(){
        System.out.println("\n");
        System.out.println("\n ------------------------- Inside AuthorController.newAuthor -------------------------");
        System.out.println("\n");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newAuthor");
        return modelAndView;
    }

}
