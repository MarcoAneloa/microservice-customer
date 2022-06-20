package com.store.inventory.customer.infrastructure.controller;

import com.store.inventory.customer.domain.model.Customer;
import com.store.inventory.customer.domain.usecase.command.CreateCustomerUseCase;
import com.store.inventory.customer.domain.usecase.command.DeleteCustomerUseCase;
import com.store.inventory.customer.domain.usecase.command.UpdateCustomerUseCase;
import com.store.inventory.customer.domain.usecase.query.GetCustomersUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    private final GetCustomersUseCase getCustomersUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;
    private final CreateCustomerUseCase createCustomerUseCase;

    public CustomerController(GetCustomersUseCase getCustomersUseCase, UpdateCustomerUseCase updateCustomerUseCase, DeleteCustomerUseCase deleteCustomerUseCase, CreateCustomerUseCase createCustomerUseCase) {
        this.getCustomersUseCase = getCustomersUseCase;
        this.updateCustomerUseCase = updateCustomerUseCase;
        this.deleteCustomerUseCase = deleteCustomerUseCase;
        this.createCustomerUseCase = createCustomerUseCase;
    }

    @GetMapping
    ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok().body(getCustomersUseCase.ask());
    }

    @PostMapping
    int saveCustomer(@Valid @RequestBody Customer customer) {
        return createCustomerUseCase.execute(customer);
    }

    @PutMapping
    int updateCustomer(@Valid @RequestBody Customer customer) {
        return updateCustomerUseCase.execute(customer);
    }

    @DeleteMapping("{id}")
    int deleteCustomer(@PathVariable("id") Long id) {
        return deleteCustomerUseCase.execute(id);
    }
}
