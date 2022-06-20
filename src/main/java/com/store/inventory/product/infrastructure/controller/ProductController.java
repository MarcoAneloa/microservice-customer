package com.store.inventory.product.infrastructure.controller;

import com.store.inventory.customer.domain.model.Customer;
import com.store.inventory.product.domain.model.Product;
import com.store.inventory.product.domain.model.request.ProductDTO;
import com.store.inventory.product.domain.usecase.command.UpdateProductUseCase;
import com.store.inventory.product.domain.usecase.query.GetProductUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final GetProductUseCase getProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;

    public ProductController(GetProductUseCase getProductUseCase, UpdateProductUseCase updateProductUseCase) {
        this.getProductUseCase = getProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
    }


    @GetMapping
    ResponseEntity<List<Product>> getCustomers() {
        return ResponseEntity.ok().body(getProductUseCase.ask());
    }

    @PutMapping
    int updateCustomer(@Valid @RequestBody ProductDTO product) {
        return updateProductUseCase.execute(product);
    }

}
