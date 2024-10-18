package com.microservice.customer.domain.usecase.command;

import com.microservice.customer.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerUseCase {

    private final CustomerRepository customerRepository;

    public DeleteCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public int execute(Long id) {
        return customerRepository.deleteById(id);
    }
}
