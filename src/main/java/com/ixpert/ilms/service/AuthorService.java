package com.ixpert.ilms.service;

import com.ixpert.ilms.model.Author;
import java.util.List;

public interface AuthorService {
    public Author getAuthorById(Integer id);
    public void saveAuthor(Author author);
    public void deleteAuthorById(Integer id);
    public List<Author> getAllAuthors();
}
