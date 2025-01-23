package com.bookstore.BookstoreApp.services.Customer;

import com.bookstore.BookstoreApp.entities.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);

    boolean existsByEmail(String email);
}
