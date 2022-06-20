package com.store.inventory.product.domain.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store.inventory.product.domain.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class ResponseProductApiRest {

    @JsonProperty(value = "prods")
    private List<Product> products;
}
