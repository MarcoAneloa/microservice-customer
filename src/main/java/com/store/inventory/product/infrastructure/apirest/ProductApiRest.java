package com.store.inventory.product.infrastructure.apirest;

import com.store.inventory.product.domain.model.Product;
import com.store.inventory.product.domain.model.response.ResponseProductApiRest;
import com.store.inventory.product.domain.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Repository
public class ProductApiRest implements ProductRepository {

    private final RestTemplate restTemplate;

    public ProductApiRest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> findAll() {
        ResponseEntity<ResponseProductApiRest> response =
                restTemplate.getForEntity("https://mocki.io/v1/57b06acc-530c-4221-b3cf-07dc9b842927", ResponseProductApiRest.class);
        return Objects.requireNonNull(response.getBody()).getProducts();
    }
}
