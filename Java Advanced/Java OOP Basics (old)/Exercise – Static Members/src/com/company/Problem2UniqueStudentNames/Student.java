package com.company.Problem2UniqueStudentNames;

public class Student {
    private String name;

    public Student(String name) {
        this.setName(name);
    }

    private void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("The name cannot be null.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
