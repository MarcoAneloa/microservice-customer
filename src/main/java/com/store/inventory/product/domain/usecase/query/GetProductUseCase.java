package com.store.inventory.product.domain.usecase.query;

import com.store.inventory.product.domain.model.Product;
import com.store.inventory.product.domain.repository.ProductDataBaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductUseCase {

    private final ProductDataBaseRepository productDataBaseRepository;

    public GetProductUseCase(ProductDataBaseRepository productDataBaseRepository) {
        this.productDataBaseRepository = productDataBaseRepository;
    }

    public List<Product> ask() {
        return productDataBaseRepository.findAll();
    }
}
