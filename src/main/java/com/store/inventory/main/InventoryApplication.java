package com.store.inventory.main;

import com.store.inventory.product.domain.usecase.command.LoadProductUseCase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class InventoryApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(InventoryApplication.class, args);

        LoadProductUseCase loadProductUseCase = (LoadProductUseCase) app.getBean("loadProductUseCase");
        loadProductUseCase.loadProduct();
    }

}
