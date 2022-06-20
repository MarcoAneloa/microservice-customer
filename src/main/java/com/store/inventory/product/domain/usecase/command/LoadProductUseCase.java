package com.store.inventory.product.domain.usecase.command;

import com.store.inventory.product.domain.model.Product;
import com.store.inventory.product.domain.repository.ProductDataBaseRepository;
import com.store.inventory.product.domain.repository.ProductRepository;
import com.store.inventory.product.infrastructure.apirest.ProductApiRest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadProductUseCase {

    private final ProductRepository productApiRestRepository;
    private final ProductDataBaseRepository productDataBaseRepository;

    public LoadProductUseCase(ProductRepository productApiRestRepository, ProductDataBaseRepository productDataBaseRepository) {
        this.productApiRestRepository = productApiRestRepository;
        this.productDataBaseRepository = productDataBaseRepository;
    }

    public void loadProduct() {
        List<Product> products = productApiRestRepository.findAll();
        products.forEach(productDataBaseRepository::save);
    }
}
