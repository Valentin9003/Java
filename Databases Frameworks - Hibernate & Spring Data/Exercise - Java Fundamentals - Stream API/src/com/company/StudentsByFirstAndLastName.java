package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> studentsNames = new ArrayList<>();

        String inputLine = reader.readLine();
        while (!inputLine.equals("END")) {
            studentsNames.add(inputLine);
            inputLine = reader.readLine();
        }

        studentsNames.stream()
                .filter(x -> (x.split(" ")[0].compareTo(x.split(" ")[1])) < 0)
                .forEach(System.out::println);
    }
}
