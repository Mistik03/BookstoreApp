package com.bookstore.BookstoreApp.services.Author.impl;

import com.bookstore.BookstoreApp.entities.Author;
import com.bookstore.BookstoreApp.repositories.AuthorRepository;
import com.bookstore.BookstoreApp.services.Author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with ID: " + id));
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        Author existingAuthor = getAuthorById(id);
        existingAuthor.setName(author.getName());
        existingAuthor.setBiography(author.getBiography());
        return authorRepository.save(existingAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = getAuthorById(id);
        authorRepository.delete(author);
    }
}
