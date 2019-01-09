package com.ixpert.ilms.controller;

import com.ixpert.ilms.model.Author;
import com.ixpert.ilms.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping
    public String showAllAuthors(Model model){
        model.addAttribute("allAuthors",authorService.findAllAuthors());
        return "authors";
    }


    @PostMapping(value = "/save")
    public String saveAuthor(Author author){

        System.out.println("\n ***** inside AuthorController.saveAuthor *****");

        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Long id){
        authorService.deleteAuthor(id);
        return "redirect:/authors";
    }


    @GetMapping(value = "/find/{id}")
    @ResponseBody
    public Author findAuthor(@PathVariable("id") Long id){
        return authorService.findAuthor(id);
    }


}
