package com.company.problem3Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MankindMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputHuman = reader.readLine().split("\\s+");
        try {
            while (!inputHuman[0].equals("END")) {
                if (inputHuman.length == 3) {
                    createStudent(inputHuman);
                } else {
                    createWorker(inputHuman);
                }
                inputHuman = reader.readLine().split("\\s+");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void createWorker(String[] inputHuman) {
        String firstName = inputHuman[0];
        String lastName = inputHuman[1];
        double weekSalary = Double.valueOf(inputHuman[2]);
        double workHoursPerDay = Double.valueOf(inputHuman[3]);
        Human human = new Worker(firstName, lastName, weekSalary, workHoursPerDay);
        System.out.println(human.toString());
    }

    private static void createStudent(String[] inputHuman) {
        String firstName = inputHuman[0];
        String lastName = inputHuman[1];
        String facultyNumber = inputHuman[2];
        Human human = new Student(firstName, lastName, facultyNumber);
        System.out.println(human.toString());
    }
}
