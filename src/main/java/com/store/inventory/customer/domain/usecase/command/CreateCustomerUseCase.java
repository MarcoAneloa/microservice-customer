package com.store.inventory.customer.domain.usecase.command;

import com.store.inventory.customer.domain.model.Customer;
import com.store.inventory.customer.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerUseCase {

    private final CustomerRepository customerRepository;

    public CreateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public int execute(Customer customer) {
        return customerRepository.save(customer);
    }
}
