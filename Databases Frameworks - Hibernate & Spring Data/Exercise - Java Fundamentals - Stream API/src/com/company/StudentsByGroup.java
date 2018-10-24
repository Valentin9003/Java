package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> studGroup2 = new ArrayList<>();

        String[] inputLine = reader.readLine().split("\\s+");
        while (!inputLine[0].equals("END")) {
            int group = Integer.parseInt(inputLine[2]);
            if (group == 2) {
                String firstName = inputLine[0];
                String lastName = inputLine[1];
                studGroup2.add(String.format("%s %s", firstName, lastName));
            }
            inputLine = reader.readLine().split("\\s+");
        }
        studGroup2.stream()
                .sorted(Comparator.comparing(x -> x.split(" ")[0]))
                .forEach(System.out::println);
    }
}
