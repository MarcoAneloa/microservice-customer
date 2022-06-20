package com.store.inventory.customer.domain.repository;

import com.store.inventory.customer.domain.model.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    int save(Customer customer);

    int update(Customer customer);

    int deleteById(Long id);
}
