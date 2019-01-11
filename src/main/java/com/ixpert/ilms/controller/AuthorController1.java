package com.ixpert.ilms.controller;


import com.ixpert.ilms.model.Author;
import com.ixpert.ilms.model.PagerModel;
import com.ixpert.ilms.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping(value = "/author")
public class AuthorController1 {

    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = {5,10};

    @Autowired
    AuthorRepository authorRepository;


    @GetMapping
    public ModelAndView showAllAuthors(@RequestParam("pageSize") Optional<Integer> pageSize, @RequestParam("page") Optional<Integer> page){
        ModelAndView modelAndView = new ModelAndView("authors");

        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        System.out.println("\n **************** Inside AuthorController1.showAllAuthors *********");
        System.out.println("\n Here is the AuthorRepo "+authorRepository.findAll());

        Page<Author> authorsList = authorRepository.findAll(PageRequest.of(evalPage, evalPageSize));
        System.out.println("\n Total pages= "+authorsList.getTotalPages() + " author list get number= "+authorsList.getNumber());

        PagerModel pagerModel = new PagerModel(authorsList.getTotalPages(), authorsList.getNumber(),BUTTONS_TO_SHOW);

        modelAndView.addObject("allAuthors",authorsList);
        modelAndView.addObject("selectedPageSize",evalPageSize);
        modelAndView.addObject("pageSizes",PAGE_SIZES);
        modelAndView.addObject("pager",pagerModel);

        return modelAndView;

    }




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
    @ResponseBody
    public Author findAuthor(@PathVariable("id") Long id){
        return authorRepository.findById(id).get();
    }










}
