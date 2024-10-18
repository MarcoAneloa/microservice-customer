package com.microservice.customer.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
public class Customer {

    private Integer id;

    @NotBlank(message = "Name can not be null")
    private String name;

    @NotBlank(message = "Address can not be null")
    private String address;

    @NotBlank(message = "Phone can not be null")
    private String phone;

    @NotBlank(message = "Password can not be null")
    private String password;

    @NotNull(message = "State can not be null")
    private Boolean state;


}
