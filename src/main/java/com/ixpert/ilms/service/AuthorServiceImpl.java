package com.ixpert.ilms.service;

import com.ixpert.ilms.model.Author;
import com.ixpert.ilms.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author findAuthor(Long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public Author createAuthor(Author author) {
        Author created = authorRepository.save(author);
        return created;
    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = findAuthor(id);
        if (author != null)
        authorRepository.delete(author);
    }
}
