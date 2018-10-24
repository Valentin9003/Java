package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class WeakStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer[]> students = new LinkedHashMap<>();

        String[] inputLine = reader.readLine().split("\\s+");
        while (!inputLine[0].equals("END")) {
            String name = String.format("%s %s", inputLine[0], inputLine[1]);
            Integer[] studentBook = Arrays.stream(inputLine).skip(2).map(Integer::parseInt).toArray(Integer[]::new);

            students.putIfAbsent(name, studentBook);

            inputLine = reader.readLine().split("\\s+");
        }

        students.entrySet().stream().filter(x -> {
            return Arrays.stream(x.getValue()).filter(mark -> mark <= 3).count() >= 2;
        }).forEach(stud -> System.out.println(stud.getKey()));

    }
}
