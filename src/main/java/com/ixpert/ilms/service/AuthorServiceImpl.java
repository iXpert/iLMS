package com.ixpert.ilms.service;

import com.ixpert.ilms.model.Author;
import com.ixpert.ilms.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private static final int PAGE_SIZE = 15;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author getAuthorById(Integer id) {
        return authorRepository.findById(id)
                .orElse(null);
    }

    @Override
    public void saveAuthor(Author author) {
        if (author != null)
            authorRepository.save(author);
    }

    @Override
    public void deleteAuthorById(Integer id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}