package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> students = new ArrayList<>();

        String inputLine = reader.readLine();
        while (!inputLine.equals("END")) {
            students.add(inputLine);
            inputLine = reader.readLine();
        }

        students.stream()
                .filter(stud ->
                        Integer.parseInt(stud.split(" ")[2]) >= 18
                        && Integer.parseInt(stud.split(" ")[2]) <= 24)
                .forEach(System.out::println);
    }
}
