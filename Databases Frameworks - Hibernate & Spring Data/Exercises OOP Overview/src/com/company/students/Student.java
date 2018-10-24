package com.company.students;

public class Student {
    private static final int DEFAULT_STUDENTS_COUNT = 0;

    private String name;
    private static int studentsCount;

    public Student(String name) {
        this.setName(name);
        studentsCount++;
    }

    private void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be NULL.");
        } else {
            this.name = name;
        }
    }

    public static int getStudentsCount() {
        return studentsCount;
    }

    @Override
    public String toString() {
        return String.format("%d", studentsCount);
    }
}
