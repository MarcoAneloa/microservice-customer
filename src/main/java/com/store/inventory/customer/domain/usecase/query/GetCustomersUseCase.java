package com.store.inventory.customer.domain.usecase.query;

import com.store.inventory.customer.domain.model.Customer;
import com.store.inventory.customer.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCustomersUseCase {

    private final CustomerRepository customerRepository;

    public GetCustomersUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> ask() {
        return customerRepository.findAll();
    }
}
