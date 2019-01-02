package com.ixpert.ilms.service;

import com.ixpert.ilms.model.Book;

import java.util.List;

public interface BookService {

    public List<Book> findAllBooks();
    public Book findBook(Long id);
    public void saveBook(Book book);
    public Book createBook(Book book);
    public void deleteBook(Long id);


}
