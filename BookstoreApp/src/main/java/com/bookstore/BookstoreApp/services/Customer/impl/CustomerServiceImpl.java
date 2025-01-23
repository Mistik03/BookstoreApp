package com.bookstore.BookstoreApp.services.Customer.impl;

import com.bookstore.BookstoreApp.entities.Customer;
import com.bookstore.BookstoreApp.repositories.CustomerRepository;
import com.bookstore.BookstoreApp.services.Customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
    }

    @Override
    public Customer createCustomer(Customer customer) {
        if (existsByEmail(customer.getEmail())) {
            throw new RuntimeException("Customer with email " + customer.getEmail() + " already exists");
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer existingCustomer = getCustomerById(id);
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        return customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }

    @Override
    public boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }
}
