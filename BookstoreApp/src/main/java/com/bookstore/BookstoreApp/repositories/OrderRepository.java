package com.bookstore.BookstoreApp.repositories;

import com.bookstore.BookstoreApp.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // 1. Find orders by customer ID
    List<Order> findByCustomerId(Long customerId);

    // 2. Find orders placed between specific dates
    List<Order> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // 3. Find orders with total amount greater than a specific value
    List<Order> findByTotalAmountGreaterThan(Double amount);

    // 4. Custom JPQL query: Find total revenue
    @Query("SELECT SUM(o.totalAmount) FROM Order o")
    Double calculateTotalRevenue();

    // 5. Find orders sorted by order date (descending)
    List<Order> findAllByOrderByOrderDateDesc();
}
