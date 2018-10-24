package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BookLibrary {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Library> libraryList = new ArrayList<>();
        List<Books> booksList = new ArrayList<>();

        Map<String, Double> myBookMap = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            AddBook(booksList, input, myBookMap);
            AddLibraryList(booksList, input, libraryList);
        }

        Print(myBookMap);

    }

    private static void Print(Map<String, Double> myBookMap) {
        TreeMap<String, Double> printSorted = new TreeMap<>();
        printSorted.putAll(myBookMap);

        printSorted.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.println(String.format("%s -> %.2f", k.getKey(), k.getValue())));
    }

    private static void AddLibraryList(List<Books> booksList, String[] input, List<Library> libraryList)
    {
        Library library = new Library();
        library.Name = input[1];
        library.booksInfo = booksList;

        libraryList.add(library);
    }

    private static void AddBook(List<Books> booksList, String[] input, Map<String, Double> myBookMap)
    {
        Books book = new Books();
        book.Name = input[1];
        book.Title = input[0];
        book.Publisher = input[2];
        book.ReleaseData = input[3];
        book.ISBN = Long.parseLong(input[4]);
        book.Price = Double.parseDouble(input[5]);
        booksList.add(book);

        if (!myBookMap.containsKey(book.Name)) {
            myBookMap.put(book.Name, book.Price);
        } else {
            double price = myBookMap.get(book.Name);
            price += book.Price;
            myBookMap.replace(book.Name, price);
        }
    }

}
class Library
{
    String Name;
    public List<Books> booksInfo = new ArrayList<>();
}
class Books {
    String Name;
    String Title;
    String Publisher;
    String ReleaseData;
    long ISBN;
    double Price;
}