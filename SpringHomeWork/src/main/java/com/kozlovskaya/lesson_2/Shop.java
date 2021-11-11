package com.kozlovskaya.lesson_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shop {

    private Cart cart;

    public void start(AnnotationConfigApplicationContext context) {
        System.out.println("ShopApp started");
        while (true) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String line;
                String command;
                Long id;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\s+");
                    if (parts.length == 1) {
                        command = parts[0];
                        if (command.equals(Constants.CREATE_CART)) {
                            this.cart = context.getBean(Cart.class);
                        }
                        if (command.equals(Constants.PRODUCTS_LIST)) {
                            System.out.println(cart.getAvailableProducts());
                        }
                        if (command.equals(Constants.CART_STATUS)) {

                            if (cart.getCartStatus().size() != 0) {
                                System.out.println(cart.getCartStatus());
                            } else {
                                System.out.println("В корзине пусто");
                            }
                        }
                    } else {
                        command = parts[0];
                        id = Long.valueOf(parts[1]);
                        if (command.equals(Constants.ADD_IN_CART)) {
                            cart.addById(id);
                        }

                        if (command.equals(Constants.DELETE_FROM_CART)) {
                            cart.deleteById(id);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
