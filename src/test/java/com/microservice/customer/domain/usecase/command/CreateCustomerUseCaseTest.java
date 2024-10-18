package com.microservice.customer.domain.usecase.command;

import com.microservice.customer.domain.model.Customer;
import com.microservice.customer.domain.repository.CustomerRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateCustomerUseCaseTest {
    @Mock
    CustomerRepository customerRepository;

    @Mock
    Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer(1, "", "", "","",true);
    }

    @Test
    void execute() {

        when(customerRepository.save(customer)).thenReturn(1);

        CreateCustomerUseCase createCustomerUseCase = new CreateCustomerUseCase(customerRepository);
        int response = createCustomerUseCase.execute(customer);

        assertThat(response, Matchers.is(1));
    }

    @Test
    void executeFail() {
        when(customerRepository.save(customer)).thenReturn(0);

        CreateCustomerUseCase createCustomerUseCase = new CreateCustomerUseCase(customerRepository);
        int response = createCustomerUseCase.execute(customer);

        assertThat(response, Matchers.is(0));
    }
}