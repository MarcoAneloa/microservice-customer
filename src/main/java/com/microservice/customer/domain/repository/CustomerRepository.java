package com.microservice.customer.domain.repository;

import com.microservice.customer.domain.model.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    int save(Customer customer);

    int update(Customer customer);

    int deleteById(Long id);
}
