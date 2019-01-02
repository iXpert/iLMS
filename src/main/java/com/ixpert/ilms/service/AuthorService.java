package com.ixpert.ilms.service;

import com.ixpert.ilms.model.Author;

import java.util.List;

public interface AuthorService {

    public List<Author> findAllAuthors();
    public Author findAuthor(Long id);
    public void saveAuthor(Author author);
    public Author createAuthor(Author author);
    public void deleteAuthor(Long id);


}
