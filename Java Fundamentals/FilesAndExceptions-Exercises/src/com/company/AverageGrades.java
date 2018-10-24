package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AverageGrades {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfStudents = Integer.parseInt(reader.readLine());

        List<Student> result = new ArrayList<>();
        for (int i = 0; i < numberOfStudents; i++) {
            String[] input = reader.readLine().split(" ");
            Student student = new Student();
            student.setName(input[0]);

            List<Double> buffList = new ArrayList<>();
            for (int j = 1; j < input.length; j++) {
                buffList.add(Double.parseDouble(input[j]));
            }
            student.setGradesList(buffList);

            if (student.Average() >= 5.00) {
                result.add(student);
            }
        }
        result.sort(Comparator.comparing(Student::getName).thenComparing(Student::getAverage));

        Writer writerOutput = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("outputP08.txt"), "utf-8"));
        {
            for (Student student : result) {
                   writerOutput.write(String.format("%s -> %.2f%n", student.getName(), student.Average()));
            }
        }
        writerOutput.close();

    }
}
class Student
{
    private String name;
    private List<Double> gradesList = new ArrayList<>();
    private Double average = CalculateAverage(gradesList);

//    public Student(String name, List<Double> gradesList) {
//        this.name = name;
//        this.gradesList = gradesList;
//    }


    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getGradesList() {
        return gradesList;
    }

    public void setGradesList(List<Double> gradesList) {
        this.gradesList = gradesList;
    }

    public double Average() {
        double sumGrades = 0;
        for (Double grade : gradesList) {
            sumGrades += grade;
        }

        return (sumGrades / gradesList.size());
    }

    private Double CalculateAverage(List<Double> gradesList) {
        double sumGrades = 0;
        for (Double grade : gradesList) {
            sumGrades += grade;
        }

        return (sumGrades / gradesList.size());
    }
}
