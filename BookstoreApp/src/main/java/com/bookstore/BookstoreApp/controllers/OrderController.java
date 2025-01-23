package com.bookstore.BookstoreApp.controllers;

import com.bookstore.BookstoreApp.entities.Order;
import com.bookstore.BookstoreApp.services.Order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Get all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Get an order by ID
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // Create a new order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    // Delete an order
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    // Get orders by customer ID
    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomerId(@PathVariable Long customerId) {
        return orderService.getOrdersByCustomerId(customerId);
    }

    // Get orders within a date range
    @GetMapping("/date-range")
    public List<Order> getOrdersWithinDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        return orderService.getOrdersWithinDateRange(start, end);
    }

    // Calculate total revenue
    @GetMapping("/revenue")
    public Double calculateTotalRevenue() {
        return orderService.calculateTotalRevenue();
    }
}
