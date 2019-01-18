package com.ixpert.ilms.controller;

import com.ixpert.ilms.model.Author;
import com.ixpert.ilms.repository.AuthorRepository;
import com.ixpert.ilms.util.PageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @PostMapping(value = "/save")
    public String saveAuthor(Author author){
        authorRepository.save(author);
        return "redirect:/author";
    }


    @GetMapping(value = "/new")
    public ModelAndView newAuthor(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newAuthor");
        return modelAndView;
    }

    @PostMapping(value = "/author/delete/{id}")
    public ModelAndView deleteAuthor(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        authorRepository.deleteById(id);
        modelAndView.setViewName("authors");
        return modelAndView;
    }

   @GetMapping
   public ModelAndView displayAllAuthors(@PageableDefault(value = 15) Pageable pageable){
       ModelAndView modelAndView = new ModelAndView();
       Page<Author> authorsPage = authorRepository.findAll(pageable);
       PageWrapper<Author> page = new PageWrapper(authorsPage,"/author");
       modelAndView.addObject("allAuthors",authorsPage.getContent());
       modelAndView.addObject("page",page);
       modelAndView.setViewName("authors");
       return modelAndView;
   }

   @GetMapping(value = "/find/{id}")
   public ModelAndView find(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        Author currentAuthor = authorRepository.findById(id).get();
        modelAndView.addObject("currentAuthor",currentAuthor);
        return modelAndView;
   }






}
