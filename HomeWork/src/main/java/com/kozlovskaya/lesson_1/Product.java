package com.kozlovskaya.lesson_1;

public class Product {
    private int id;
    private String title;
    private int coast;

    public Product(int id, String title, int coast) {
        this.id = id;
        this.title = title;
        this.coast = coast;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCoast() {
        return coast;
    }

    @Override
    public String toString() {
        return "id = " + id + ", title = " + title + ", coast = " + coast + ";";
    }
}
