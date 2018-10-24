package p04_shoppingSpree.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private String name;
    private double money;
    private List<Product> bagOfProducts;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void addMoneyToBudget(double money) {
        this.setMoney(this.money + money);
    }

    public List<Product> getBagOfProducts() {
        return Collections.unmodifiableList(this.bagOfProducts);
    }

    public void buyProduct(Product product) {
        if (this.getMoney() < product.getCost()) {
            throw new IllegalArgumentException(
                    String.format("%s can't afford %s", this.getName(), product.getName()));
        }
        buy(product);
    }

    private void buy(Product product) {
        this.setMoney(this.money - product.getCost());
        this.bagOfProducts.add(product);
    }

    @Override
    public String toString() {
        List<String> resultList =
                this.bagOfProducts.stream().map(Product::getName).collect(Collectors.toList());

        return String.format("%s - %s",
                this.getName(),
                resultList.size() > 0 ? String.join(", ", resultList) : "Nothing bought");
    }
}
