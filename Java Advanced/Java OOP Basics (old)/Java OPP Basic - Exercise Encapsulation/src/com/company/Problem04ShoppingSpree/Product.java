package com.company.problem04ShoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be an empty string.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be a negative number.");
        }
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return String.format("%s", this.getName());
    }
}
