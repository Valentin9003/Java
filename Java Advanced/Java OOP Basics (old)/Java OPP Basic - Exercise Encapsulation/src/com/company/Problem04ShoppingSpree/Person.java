package com.company.problem04ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> bagProducts;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bagProducts = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be an empty string");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be a negative number.");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (product.getCost() > this.money) {
            System.out.println(String.format("%s can't afford %s", this.name, product.getName()));
        } else {
            this.money -= product.getCost();
            addProductsInBag(product);

            System.out.println(String.format("%s bought %s", this.name, product.getName()));
        }
    }

    public void printBag() {
        if (this.bagProducts.size() > 0) {
            List<String> forPrint = new ArrayList<>();
            this.bagProducts.forEach(product -> {
                forPrint.add(product.toString());
            });

            System.out.print(String.format("%s - ", this.name));
            System.out.println(String.join(", ", forPrint));
        } else {
            System.out.println(String.format("%s - Nothing bought", this.name));
        }
    }

    private void addProductsInBag(Product product) {
        this.bagProducts.add(product);
    }
}
