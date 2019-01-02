package com.ixpert.ilms.repository;

import com.ixpert.ilms.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryRepository extends JpaRepository<Category, Long> {
}
