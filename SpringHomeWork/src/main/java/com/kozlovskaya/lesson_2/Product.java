package com.kozlovskaya.lesson_2;


public class Product {
    private Long id;
    private String title;
    private int coast;

    public Product() {
    }

    public Product(Long id, String title, int coast) {
        this.id = id;
        this.title = title;
        this.coast = coast;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCoast() {
        return coast;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    @Override
    public String toString() {
        return "id = " + id + " title = " + title + " coast = " + coast;
    }
}
