package com.bookstore.BookstoreApp.repositories;

import com.bookstore.BookstoreApp.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // 1. Find books by title (case-insensitive, partial match)
    List<Book> findByTitleContainingIgnoreCase(String title);

    // 2. Find books by category ID
    List<Book> findByCategoryId(Long categoryId);

    // 3. Find books by author ID
    List<Book> findByAuthorId(Long authorId);

    // 4. Find books within a price range
    List<Book> findByPriceBetween(Double minPrice, Double maxPrice);

    // 5. Find books by multiple criteria (title and category)
    List<Book> findByTitleContainingAndCategoryId(String title, Long categoryId);

    // 6. Find books ordered by price (ascending)
    List<Book> findAllByOrderByPriceAsc();

    // 7. Custom JPQL query: Find books with price greater than a specific value
    @Query("SELECT b FROM Book b WHERE b.price > :price")
    List<Book> findBooksWithPriceGreaterThan(Double price);

    // 8. Count books in a category
    long countByCategoryId(Long categoryId);

    // 9. Delete books by author ID
    void deleteByAuthorId(Long authorId);
}
