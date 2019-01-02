package com.ixpert.ilms.service;

import com.ixpert.ilms.model.Book;
import com.ixpert.ilms.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBook(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book createBook(Book book) {
        Book created = bookRepository.save(book);
        return created;
    }

    @Override
    public void deleteBook(Long id) {
        Book book = findBook(id);
        if (book != null)
            bookRepository.delete(book);
    }
}
