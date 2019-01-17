package com.ixpert.ilms.repository;

import com.ixpert.ilms.model.Author;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface AuthorRepository extends PagingAndSortingRepository<Author, Integer> {
}
