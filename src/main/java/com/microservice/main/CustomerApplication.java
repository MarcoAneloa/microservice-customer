package com.microservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(CustomerApplication.class, args);
    }

}
