package com.geekbrains.spring.mvc.model;

public class Product {
    private Long id;
    private String title;
    private Double cost;

    public Product(Long id, String title, Double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Product(String title, Double cost) {
        this.title = title;
        this.cost = cost;
    }

    public Product() {}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getCost() {
        return cost;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "#" + this.id + " " + this.title + " " + this.cost;
    }
}