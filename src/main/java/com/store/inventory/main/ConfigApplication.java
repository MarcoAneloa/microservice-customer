package com.store.inventory.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = "com.store.inventory.customer," +
        "com.store.inventory.shared," +
        "com.store.inventory.product")
@Configuration
public class ConfigApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
