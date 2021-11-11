package com.kozlovskaya.lesson_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private ProductService productService;
    private List<Product> productList;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @PostConstruct
    public void createCart() {
        productList = new ArrayList<>();
        System.out.println("Создана новая корзина");
    }

    public void addById(Long productId) {
        productList.add(productService.getProductById(productId));
    }

    public void deleteById(Long productId) {
        productList.remove(productService.getProductById(productId));
    }


    public List<Product> getCartStatus() {
        return productList;
    }

    public List<Product> getAvailableProducts() {
        return productService.getAllProducts();
    }


}
