package com.store.inventory.product.domain.repository;

import com.store.inventory.product.domain.model.Product;

import java.util.List;

public interface ProductRepository {

     List<Product> findAll();
}
