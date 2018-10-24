package com.company.averageGrades;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> studentsList = new ArrayList<>();
        int numberOfStudents = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfStudents; i++) {
            String[] inputData = reader.readLine().split("\\s+");
            createStudent(inputData, studentsList);
        }

        printResult(studentsList);
    }

    private static void printResult(List<Student> studentsList) {
        Collections.sort(studentsList);

        for (Student student : studentsList) {
            if (student.getAverageGrade() >= 5.00) {
                System.out.println(String.format("%s -> %.2f", student.getName(), student.getAverageGrade()));
            }
        }
    }

    private static void createStudent(String[] inputData,  List<Student> studentsList) {
        String name = inputData[0];
        Student student = new Student(name);

        List<Double> gradesList = new ArrayList<>();
        for (int i = 1; i < inputData.length; i++) {
            gradesList.add(Double.parseDouble(inputData[i]));
        }
        student.setGradesList(gradesList);
        student.calculateAverageGrade();

        studentsList.add(student);
    }
}
