package com.company.Problem2UniqueStudentNames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UniqueStudentNamesMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String newName = reader.readLine();

        StudentGroup studentGroup = new StudentGroup();

        while (!newName.equals("End")) {

            Student student = new Student(newName);
            studentGroup.addStudent(student);

            newName = reader.readLine();
        }

        System.out.println(studentGroup.getCountOfUniqueNames());
    }
}
