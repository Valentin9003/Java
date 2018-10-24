package com.company.Problem1Students;

public class Student {

    static Integer createdStudents = 0;
    private String name;

    public Student(String name) {
        this.setName(name);
        Student.setCreatedStudents(createdStudents);
    }

    private static void setCreatedStudents(Integer createdStudents) {
        Student.createdStudents++;
    }

    private void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("Name cannot be less than 3 letters.");
        }
        this.name = name;
    }
}
