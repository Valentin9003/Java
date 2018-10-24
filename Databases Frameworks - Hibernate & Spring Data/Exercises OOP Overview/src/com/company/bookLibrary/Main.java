package com.company.bookLibrary;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countRecords = Integer.parseInt(reader.readLine());

        Library library = new Library();

        try {
            for (int i = 0; i < countRecords; i++) {
                String[] bookData = reader.readLine().split("\\s+");
                String title = bookData[0];
                String author = bookData[1];
                String publisher = bookData[2];
                String releaseDate = bookData[3];
                String ISBN = bookData[4];
                Double price = Double.parseDouble(bookData[5]);

                Book book = new Book(title, author, publisher, releaseDate, ISBN, price);
                library.addBook(book);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(library.toString());
        }

    }
}
