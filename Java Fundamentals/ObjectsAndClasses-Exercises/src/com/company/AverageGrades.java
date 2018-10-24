package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AverageGrades {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> studList = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            AddStudentsList(input, studList);
        }

        List<Student> sortedList = new ArrayList<>();
        for (Student student : studList) {
            if (student.AvarageGrade() >= 5.00)
            {
                sortedList.add(student);
            }
        }

        sortedList.sort((stud1, stud2) -> { int result = stud1.Name.compareTo(stud2.Name);
        if (result == 0) {
                result = Double.compare(stud2.AvarageGrade(), stud1.AvarageGrade());
            }
            return result;
        });

        PrintSortedList(sortedList);

    }

    private static void PrintSortedList(List<Student> sortedList)
    {
        for (Student student : sortedList) {
            System.out.println(String.format("%s -> %.2f", student.Name, student.AvarageGrade()));
        }
    }

    private static void AddStudentsList(String[] input, List<Student> studList)
    {
        Student stud = new Student();
        stud.Name = input[0];
        for (int i = 1; i < input.length; i++) {
            stud.Grade.add(Double.parseDouble(input[i]));
        }
        studList.add(stud);
    }
}
class Student
{
    String Name;
    List<Double> Grade = new ArrayList<>();

    public double AvarageGrade()
    {
        double counter = Grade.size();
        double sum = 0;
        for (Double grade : Grade) {
            sum += grade;
        }
        return sum / counter;
    }
}
