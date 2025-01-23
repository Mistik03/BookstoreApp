package com.bookstore.BookstoreApp.repositories;

import com.bookstore.BookstoreApp.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // 1. Find customers by email (case-insensitive)
    Customer findByEmailIgnoreCase(String email);

    // 2. Find customers by name containing a keyword
    List<Customer> findByNameContainingIgnoreCase(String keyword);

    // 3. Check if a customer exists by email
    boolean existsByEmail(String email);

    // 4. Delete a customer by email
    void deleteByEmail(String email);
}
