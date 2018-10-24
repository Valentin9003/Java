package com.company.bookStore;

public class Book {

    private String name;
    private String author;
    private double price;

    public Book(String name, double price, String author) {
        this.setName(name);
        this.setAuthor(author);
        this.setPrice(price);
    }

    private void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot ne empty");
        }
        this.name = name;
    }

    private void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }
        this.author = author;
    }

    private void setPrice(double price) {
        if (price < 0.0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}
