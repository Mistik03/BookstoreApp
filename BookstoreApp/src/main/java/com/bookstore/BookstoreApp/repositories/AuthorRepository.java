package com.bookstore.BookstoreApp.repositories;

import com.bookstore.BookstoreApp.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    // 1. Find authors by name (case-insensitive match)
    List<Author> findByNameIgnoreCase(String name);

    // 2. Check if an author exists by name
    boolean existsByName(String name);

    // 3. Find authors who have written more than X books
    @Query("SELECT a FROM Author a WHERE size(a.books) > :count")
    List<Author> findAuthorsWithMoreThanXBooks(int count);
}
