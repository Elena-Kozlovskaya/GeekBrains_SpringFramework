package com.kozlovskaya.lesson_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.kozlovskaya.lesson_2");
        new Shop().start(context);
    }
}
