package com.ixpert.ilms.controller;

import com.ixpert.ilms.model.Author;
import com.ixpert.ilms.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping(value = "/author123")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping
    public ModelAndView listAuthors(@RequestParam("page")Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        ModelAndView modelAndView = new ModelAndView();

        Page<Author> allAuthors = authorRepository.findAll(PageRequest.of(currentPage-1, pageSize));
        modelAndView.addObject("allAuthors",allAuthors);

        int totalPages = allAuthors.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            modelAndView.addObject("pageNumbers",pageNumbers);

        }
        modelAndView.setViewName("authors");
        return modelAndView;
    }


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








}
