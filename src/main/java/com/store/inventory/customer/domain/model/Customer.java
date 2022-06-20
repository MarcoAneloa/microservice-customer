package com.store.inventory.customer.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
public class Customer {

    private Integer id;

    @NotBlank(message = "Name can not be null")
    private String name;

    @NotBlank(message = "Document can not be null")
    private String document;

    private String image;
}
