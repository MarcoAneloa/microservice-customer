package com.store.inventory.product.domain.repository;

import com.store.inventory.customer.domain.model.Customer;
import com.store.inventory.product.domain.model.Product;
import com.store.inventory.product.domain.model.request.ProductDTO;

import java.util.List;

public interface ProductDataBaseRepository {

    List<Product> findAll();

    int save(Product product);

    int update(ProductDTO product);

    int deleteById(Long id);
}
