package com.company.ShopingSpee;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> bagOfProducts;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void addMoneyToBudget(double money) {
        this.setMoney(this.money + money);
    }

    public void buyProduct(Product product) {
        this.bagOfProducts.add(product);
        this.setMoney(this.money - product.getCost());
    }

    @Override
    public String toString() {
        List<String> productsList = new ArrayList<>();
        for (Product product : bagOfProducts) {
            productsList.add(product.getName());
        }

        StringBuilder sb = new StringBuilder();
        if (productsList.size() > 0) {
            sb.append(String.format("%s - ", this.name))
                    .append(String.join(", ", productsList));
        } else {
            sb.append(String.format("%s - Nothing bought", this.name));
        }
        return sb.toString();
    }
}
