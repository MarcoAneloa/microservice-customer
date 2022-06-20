package com.store.inventory.product.infrastructure.controller;

import com.store.inventory.product.domain.model.request.ProductDTO;
import com.store.inventory.product.domain.usecase.command.UpdateProductUseCase;
import com.store.inventory.product.domain.usecase.query.GetProductUseCase;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    GetProductUseCase getProductUseCase;
    @Mock
    UpdateProductUseCase updateProductUseCase;

    @Test
    void updateCustomer() {

        when(updateProductUseCase.execute(any())).thenReturn(1);

        ProductController productController = new ProductController(getProductUseCase, updateProductUseCase);
        int response = productController.updateCustomer(new ProductDTO());

        assertThat(response, Matchers.is(1));
    }
}