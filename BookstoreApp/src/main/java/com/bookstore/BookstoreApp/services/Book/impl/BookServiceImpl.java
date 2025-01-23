package com.bookstore.BookstoreApp.services.Book.impl;

import com.bookstore.BookstoreApp.entities.Book;
import com.bookstore.BookstoreApp.repositories.BookRepository;
import com.bookstore.BookstoreApp.services.Book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book existingBook = getBookById(id);
        existingBook.setTitle(book.getTitle());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setPrice(book.getPrice());
        existingBook.setCategory(book.getCategory());
        existingBook.setAuthor(book.getAuthor());
        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
    }

    @Override
    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Book> filterBooksByPriceRange(Double minPrice, Double maxPrice) {
        return bookRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
