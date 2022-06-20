package com.store.inventory.product.domain.usecase.command;

import com.store.inventory.product.domain.model.Product;
import com.store.inventory.product.domain.repository.ProductDataBaseRepository;
import com.store.inventory.product.domain.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class LoadProductUseCaseTest {

    @Mock
    ProductRepository productApiRestRepository;

    @Mock
    ProductDataBaseRepository productDataBaseRepository;


    @Test
    void loadProduct() {
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());

        when(productApiRestRepository.findAll()).thenReturn(products);
        when(productDataBaseRepository.save(any())).thenReturn(1);

        LoadProductUseCase loadProductUseCase = new LoadProductUseCase(productApiRestRepository, productDataBaseRepository);
        loadProductUseCase.loadProduct();

        verify(productDataBaseRepository,times(2)).save(any());
    }
}