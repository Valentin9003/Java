package com.company.mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] studentTokens = reader.readLine().split("\\s+");
        String[] workerTokens = reader.readLine().split("\\s+");

        try {
            createHumansAndPrintInfo(studentTokens, workerTokens);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

    }

    private static void createHumansAndPrintInfo(String[] studentTokens, String[] workerTokens) {
        String firstName = studentTokens[0];
        String lastName = studentTokens[1];
        String facultyNumber = studentTokens[2];
        Human student = new Student(firstName, lastName, facultyNumber);

        String fName = workerTokens[0];
        String lName = workerTokens[1];
        double weekSalary = Double.parseDouble(workerTokens[2]);
        double salaryPerHour = Double.parseDouble(workerTokens[3]);
        Human worker = new Worker(fName, lName, weekSalary, salaryPerHour);

        printInfoAboutHumans(student, worker);
    }

    private static void printInfoAboutHumans(Human student, Human worker) {
        System.out.println(student.toString());
        System.out.println(worker.toString());
    }
}
