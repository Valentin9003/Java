package com.company.bookLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Library {

    private String name;
    private List<Book> books;
    private Map<String, Double> booksMap;

    public Library() {
        this.books = new ArrayList<>();
        this.booksMap = new TreeMap<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
        fillBooksMap(book);
    }

    private void fillBooksMap(Book book) {
        if (this.booksMap.containsKey(book.getAuthor())) {
            double price = this.booksMap.get(book.getAuthor()) + book.getPrice();
            this.booksMap.replace(book.getAuthor(), price);
        }
        this.booksMap.putIfAbsent(book.getAuthor(), book.getPrice());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        this.booksMap.entrySet()
                .stream()
                .sorted((x1, x2) -> x2.getValue().compareTo(x1.getValue()))
                .forEach( data -> {
                    sb.append(String.format("%s -> %.2f", data.getKey(), data.getValue()))
                            .append(System.lineSeparator());
                });

        return sb.toString();
    }
}
