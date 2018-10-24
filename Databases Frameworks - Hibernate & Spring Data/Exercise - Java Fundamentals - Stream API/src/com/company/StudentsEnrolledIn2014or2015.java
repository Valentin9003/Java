package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class StudentsEnrolledIn2014or2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer[]> studentsDb = new LinkedHashMap<>();

        String inputLine = reader.readLine();
        while (!inputLine.equals("END")) {
            addStudentsInDatabase(studentsDb, inputLine);
            inputLine = reader.readLine();
        }

        printStudentsEnrolledIn2014or2015(studentsDb);
    }

    private static void printStudentsEnrolledIn2014or2015(HashMap<String, Integer[]> studentsDb) {
        studentsDb
                .entrySet()
                .stream()
                .filter(stud ->
                        stud.getKey().endsWith("14")
                                || stud.getKey().endsWith("15"))
                .forEach(s -> {
                    for (int i = 0; i < s.getValue().length; i++) {
                        System.out.print(s.getValue()[i] + " ");
                    }
                    System.out.println();
                });
    }

    private static void addStudentsInDatabase(HashMap<String, Integer[]> studentsDb, String inputLine) {
        String facultyNumber = inputLine.split("\\s+")[0];
        Integer[] studentBook = Arrays.stream(inputLine.split("\\s+")).skip(1).map(Integer::valueOf).toArray(Integer[]::new);

        studentsDb.putIfAbsent(facultyNumber, studentBook);
    }
}
