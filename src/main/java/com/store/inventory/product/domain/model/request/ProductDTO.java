package com.store.inventory.product.domain.model.request;

import lombok.Data;

@Data
public class ProductDTO {
    private String cod;
    private Integer stock;
}
