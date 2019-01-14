package com.ixpert.ilms.controller;


import com.ixpert.ilms.model.Author;
import com.ixpert.ilms.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/author890")
public class AuthorController4 {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping
    public ModelAndView showAllAuthors(@RequestParam(defaultValue = "0") int page){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allAuthors",authorRepository.findAll(PageRequest.of(page,10)));
        modelAndView.addObject("currentPage",page);
        modelAndView.setViewName("authors4");
        return modelAndView;
    }


    @PostMapping(value = "/save")
    public String saveAuthor(Author author){
        authorRepository.save(author);
        return "redirect:/author";
    }

    /*
    @GetMapping(value = "/create")
    public String createAuthor(Model model){

        System.out.println("\n ************************** Inside AuthorController4.createAuthor *************");


        Author tempAuthor = new Author();
        model.addAttribute("author",tempAuthor);
        return "newAuthor";
    }

*/
    @GetMapping(value = "/new")
    public ModelAndView newAuthor(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newAuthor");
        return modelAndView;
    }





}
