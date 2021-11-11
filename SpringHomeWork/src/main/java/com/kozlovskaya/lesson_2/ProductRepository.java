package com.kozlovskaya.lesson_2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Product_1", 25),
                new Product(2L, "Product_2", 26),
                new Product(3L, "Product_3", 27),
                new Product(4L, "Product_4", 28),
                new Product(5L, "Product_5", 29)
        ));
    }

    public Product findById(Long productId) {
        return products
                .stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst().orElseThrow(() -> new RuntimeException());
    }

    public List<Product> getAllProducts() {
        return products;
    }

}
