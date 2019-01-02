package com.ixpert.ilms.service;

import com.ixpert.ilms.model.Category;
import com.ixpert.ilms.repository.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Override
    public List<Category> findAllBookCategories() {
        return bookCategoryRepository.findAll();
    }

    @Override
    public Category findBookCategory(Long id) {
        return bookCategoryRepository.findById(id).get();
    }

    @Override
    public void saveBookCategory(Category category) {
        bookCategoryRepository.save(category);
    }

    @Override
    public Category createBookCategory(Category category) {
        Category created = bookCategoryRepository.save(category);
        return created;
    }

    @Override
    public void deleteBookCategory(Long id) {
        Category category = findBookCategory(id);
        if (category != null)
            bookCategoryRepository.delete(category);
    }
}
