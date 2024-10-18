package com.microservice.customer.domain.usecase.command;

import com.microservice.customer.domain.model.Customer;
import com.microservice.customer.domain.repository.CustomerRepository;
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
