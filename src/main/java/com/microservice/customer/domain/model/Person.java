package com.microservice.customer.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class Person {

    @NotBlank(message = "Name can not be null")
    private String name;

    @NotBlank(message = "Document can not be null")
    private String address;

    @NotBlank(message = "Phone can not be null")
    private String phone;
}
