package com.company.problem2BookShop;

public class GoldenEditionBook extends Book {

    public GoldenEditionBook(String author, String title, double price) {
        super(author, title, price);
    }

    @Override
    protected void setPrice(double price) {
        price += price * 0.3;
        super.setPrice(price);
    }
}
