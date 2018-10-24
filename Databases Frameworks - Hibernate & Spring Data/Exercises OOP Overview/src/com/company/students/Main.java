package com.company.students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String inputLine = reader.readLine();
            while (!inputLine.equals("End")) {
                Student student = new Student(inputLine);
                inputLine = reader.readLine();
            }
        } catch (Exception block) {
        } finally {
            System.out.println(Student.getStudentsCount());
        }

    }
}
