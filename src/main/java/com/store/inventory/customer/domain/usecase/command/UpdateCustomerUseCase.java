package com.store.inventory.customer.domain.usecase.command;

import com.store.inventory.customer.domain.model.Customer;
import com.store.inventory.customer.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomerUseCase {

    private final CustomerRepository customerRepository;


    public UpdateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public int execute(Customer customer) {
        return customerRepository.update(customer);
    }
}
