package com.bookstore.BookstoreApp.controllers;

import com.bookstore.BookstoreApp.entities.Book;
import com.bookstore.BookstoreApp.services.Book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/search")
    public List<Book> searchBooksByTitle(@RequestParam String title) {
        return bookService.searchBooksByTitle(title);
    }

    @GetMapping("/filter")
    public List<Book> filterBooksByPriceRange(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {
        return bookService.filterBooksByPriceRange(minPrice, maxPrice);
    }
}
