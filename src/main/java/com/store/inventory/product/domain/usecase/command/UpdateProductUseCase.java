package com.store.inventory.product.domain.usecase.command;

import com.store.inventory.product.domain.model.Product;
import com.store.inventory.product.domain.model.request.ProductDTO;
import com.store.inventory.product.domain.repository.ProductDataBaseRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductUseCase {

    private final ProductDataBaseRepository productDataBaseRepository;

    public UpdateProductUseCase(ProductDataBaseRepository productDataBaseRepository) {
        this.productDataBaseRepository = productDataBaseRepository;
    }

    public int execute(ProductDTO product) {
        return productDataBaseRepository.update(product);
    }
}
