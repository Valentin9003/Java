package com.company.ShopingSpee;

public class Product {

    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }

    public void addNewCost(double cost) {
        this.setCost(cost);
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
