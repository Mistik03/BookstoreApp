package com.bookstore.BookstoreApp.services.Category;

import com.bookstore.BookstoreApp.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category createCategory(Category category);

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);
}
