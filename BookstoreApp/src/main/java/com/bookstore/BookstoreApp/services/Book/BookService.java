package com.bookstore.BookstoreApp.services.Book;

import com.bookstore.BookstoreApp.entities.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book createBook(Book book);

    Book updateBook(Long id, Book book);

    void deleteBook(Long id);

    List<Book> searchBooksByTitle(String title);

    List<Book> filterBooksByPriceRange(Double minPrice, Double maxPrice);
}
