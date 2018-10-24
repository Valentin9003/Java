package com.company.bookStore;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Stream<Book> books = Stream.of(
                new Book("Vinetu3", 20, "Karl Mai"),
                new Book("Vinetu1", 20, "Karl Mai"),
                new Book("Vinetu2", 15, "Karl Mai"),
                new Book("Sherlock Holmes", 12, "Arthur C. Doyl"),
                new Book("The Lost World", 43, "Arthur C. Doyl"),
                new Book("Hunger games", 150, "Suzan Colins"));

        Set<Map.Entry<String, Double>> booksByAuthor =
                books.collect(
                        Collectors.groupingBy(Book::getAuthor,
                        Collectors.summingDouble(Book::getPrice)))
                .entrySet();

        booksByAuthor.stream()
                .sorted(Comparator.comparing(Map.Entry<String, Double>::getValue)
                    .reversed()
                    .thenComparing(Map.Entry<String, Double>::getKey))
                .forEach(System.out::println);
    }
}


