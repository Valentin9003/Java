package com.company.problem7CompanyHierarchy.models;

import com.company.problem7CompanyHierarchy.interfaces.ISale;

import java.util.Calendar;

public class Sale implements ISale {

    private String productName;
    private Calendar date;
    private double price;

    public Sale(String productName, Calendar date, double price) {
        this.setProductName(productName);
        this.setDate(date);
        this.setPrice(price);
    }

    public String getProductName() {
        return productName;
    }

    private void setProductName(String productName) {
        if (productName == null || productName.length() < 3) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.productName = productName;
    }

    public Calendar getDate() {
        return date;
    }

    private void setDate(Calendar date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.price = price;
    }

}
