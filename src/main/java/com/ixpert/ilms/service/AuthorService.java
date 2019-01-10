package com.ixpert.ilms.service;

import com.ixpert.ilms.model.Author;
import com.ixpert.ilms.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final static int PAGE_SIZE=10;

    @Autowired
    AuthorRepository authorRepository;

    public void saveAuthor(Author author){
        authorRepository.save(author);
    }

    public Iterable<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public List<Author> getPage(int pageNumber){
        PageRequest request = PageRequest.of(pageNumber,PAGE_SIZE);
        List<Author> authors = authorRepository.findAll(request).getContent();
        System.out.println("\n ****************** Inside AuthorService.getPage. Authors count= "+authors.size()+" *******");
        return authors;
    }

    public void deleteAuthor(Long id){
        Author currentAuthor = authorRepository.findById(id).get();
        if (currentAuthor != null)
            authorRepository.delete(currentAuthor);
    }


    public Author findAuthor(Long id){
        return authorRepository.findById(id).get();
    }

}
