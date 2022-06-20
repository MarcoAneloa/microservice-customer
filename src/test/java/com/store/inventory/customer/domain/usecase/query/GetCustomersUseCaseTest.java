package com.store.inventory.customer.domain.usecase.query;

import com.store.inventory.customer.domain.model.Customer;
import com.store.inventory.customer.domain.repository.CustomerRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetCustomersUseCaseTest {

    @Mock
    CustomerRepository customerRepository;


    @Test
    void askEmpty() {

        when(customerRepository.findAll()).thenReturn(Collections.emptyList());

        GetCustomersUseCase getCustomersUseCase = new GetCustomersUseCase(customerRepository);
        List<Customer> customers = getCustomersUseCase.ask();

        assertThat(customers, Matchers.is(Matchers.empty()));
    }

    @Test
    void ask() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "", "", ""));

        when(customerRepository.findAll()).thenReturn(customers);

        GetCustomersUseCase getCustomersUseCase = new GetCustomersUseCase(customerRepository);
        List<Customer> response = getCustomersUseCase.ask();

        assertThat(response.size(), Matchers.is(1));
    }
}