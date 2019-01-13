package com.ixpert.ilms.controller;

import com.ixpert.ilms.model.Author;
import com.ixpert.ilms.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/author1011")
public class AuthorController3 {

    @Autowired
    AuthorRepository authorRepository;


    @PostMapping(value = "/save")
    public String saveAuthor(Author author){
        authorRepository.save(author);
        return "redirect:/author";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Long id){
        authorRepository.deleteById(id);
        return "redirect:/author";
    }


    @GetMapping(value = "/find/{id}")
    public String findAuthor(Model model, @PathVariable("id") Long id){

        System.out.println("\n ******* Inside AuthorController3.findAuthor ***********");
        Author currentAuthor = authorRepository.findById(id).get();
        model.addAttribute("author",currentAuthor);
        return "newAuthor";
    }


    @GetMapping
    public String findAllAuthors(Model model,@RequestParam(defaultValue = "0") int page){
        model.addAttribute("allAuthors",authorRepository.findAll(PageRequest.of(page,10)));
        model.addAttribute("currentPage",page);
        return "authors2";
    }

    @GetMapping(value = "/create")
    public String createAuthor(Model model){

        Author tempAuthor = new Author();
        model.addAttribute("author",tempAuthor);
        return "newAuthor";
    }



}
