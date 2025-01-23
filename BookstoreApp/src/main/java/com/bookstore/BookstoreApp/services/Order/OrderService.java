package com.bookstore.BookstoreApp.services.Order;

import com.bookstore.BookstoreApp.entities.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    Order getOrderById(Long id);

    Order createOrder(Order order);

    void deleteOrder(Long id);

    List<Order> getOrdersByCustomerId(Long customerId);

    List<Order> getOrdersWithinDateRange(LocalDateTime startDate, LocalDateTime endDate);

    Double calculateTotalRevenue();
}
