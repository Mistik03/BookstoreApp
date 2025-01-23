package com.bookstore.BookstoreApp.services.Order.impl;

import com.bookstore.BookstoreApp.entities.Order;
import com.bookstore.BookstoreApp.repositories.OrderRepository;
import com.bookstore.BookstoreApp.services.Order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = getOrderById(id);
        orderRepository.delete(order);
    }

    @Override
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Order> getOrdersWithinDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return orderRepository.findByOrderDateBetween(startDate, endDate);
    }

    @Override
    public Double calculateTotalRevenue() {
        return orderRepository.calculateTotalRevenue();
    }
}
