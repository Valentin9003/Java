package com.company.bookLibrary;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private String releaseData;
    private String iSBN;
    private Double price;

    public Book(String title, String author, String publisher, String releaseData, String iSBN, Double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPublisher(publisher);
        this.setReleaseData(releaseData);
        this.setiSBN(iSBN);
        this.setPrice(price);
    }

    private void setTitle(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null");
        } else {
            this.title = title;
        }
    }

    private void setAuthor(String author) {
        if (author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null");
        } else {
            this.author = author;
        }
    }

    private void setPublisher(String publisher) {
        if (publisher.isEmpty()) {
            throw new IllegalArgumentException("Publisher cannot be null");
        } else {
            this.publisher = publisher;
        }
    }

    private void setReleaseData(String releaseData) {
        if (releaseData.isEmpty()) {
            throw new IllegalArgumentException("Release date cannot be null");
        } else {
            this.releaseData = releaseData;
        }
    }

    private void setiSBN(String iSBN) {
        if (iSBN.isEmpty()) {
            throw new IllegalArgumentException("iSBN cannot be null");
        } else {
            this.iSBN = iSBN;
        }
    }

    private void setPrice(Double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        } else {
            this.price = price;
        }
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }
}
