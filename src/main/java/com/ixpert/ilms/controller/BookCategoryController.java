package com.ixpert.ilms.controller;


import com.ixpert.ilms.model.Category;
import com.ixpert.ilms.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/bookCategory")
public class BookCategoryController {

    @Autowired
    private BookCategoryService bookCategoryService;

    @GetMapping
    public String showAllCategories(Model model){
        model.addAttribute("allCategories",bookCategoryService.findAllBookCategories());
        return "bookCategoryIndex";
    }


    @PostMapping(value = "/save")
    public String saveCategory(Category category){
        bookCategoryService.saveBookCategory(category);
        return "redirect:/bookCategory";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        bookCategoryService.deleteBookCategory(id);
        return "redirect:/bookCategory";
    }


    @GetMapping(value = "/find/{id}")
    @ResponseBody
    public Category findCategory(@PathVariable("id") Long id){
        return bookCategoryService.findBookCategory(id);
    }




}
