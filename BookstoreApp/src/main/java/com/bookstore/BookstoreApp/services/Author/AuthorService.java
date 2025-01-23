package com.bookstore.BookstoreApp.services.Author;

import com.bookstore.BookstoreApp.entities.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    Author getAuthorById(Long id);

    Author createAuthor(Author author);

    Author updateAuthor(Long id, Author author);

    void deleteAuthor(Long id);
}
