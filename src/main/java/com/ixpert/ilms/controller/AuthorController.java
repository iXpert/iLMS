package com.ixpert.ilms.controller;

import com.ixpert.ilms.model.Author;
import com.ixpert.ilms.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping
    public String showAllAuthors(Model model, @RequestParam(defaultValue = "1") int pageNumber){

        System.out.println("\n ****** Inside AuthorController.showAllAuthors ******");

        List<Author> authors = authorService.getPage(pageNumber);
        System.out.println("\n ****** # of authors = "+authors.size()+" ******");

        System.out.println("\n ****** Page # is: "+pageNumber+" ******");


        model.addAttribute("allAuthors",authors);
        model.addAttribute("currentPage",pageNumber);
        return "authors";
    }


    @PostMapping(value = "/save")
    public String saveAuthor(Author author){
        authorService.saveAuthor(author);
        return "redirect:/author";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Long id){
        authorService.deleteAuthor(id);
        return "redirect:/author";
    }


    @GetMapping(value = "/find/{id}")
    @ResponseBody
    public Author findAuthor(@PathVariable("id") Long id){
        return authorService.findAuthor(id);
    }


}
