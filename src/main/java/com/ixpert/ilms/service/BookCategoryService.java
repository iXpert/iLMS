package com.ixpert.ilms.service;


import com.ixpert.ilms.model.Category;

import java.util.List;

public interface BookCategoryService {

    public List<Category> findAllBookCategories();
    public Category findBookCategory(Long id);
    public void saveBookCategory(Category category);
    public Category createBookCategory(Category category);
    public void deleteBookCategory(Long id);

}
