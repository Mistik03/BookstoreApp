package com.bookstore.BookstoreApp.repositories;

import com.bookstore.BookstoreApp.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // 1. Find category by name (case-insensitive)
    List<Category> findByNameIgnoreCase(String name);

    // 2. Count books in a category
    @Query("SELECT COUNT(b) FROM Book b WHERE b.category.id = :categoryId")
    long countBooksInCategory(Long categoryId);
}
