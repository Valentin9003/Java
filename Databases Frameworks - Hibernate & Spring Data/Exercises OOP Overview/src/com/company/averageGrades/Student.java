package com.company.averageGrades;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student>{
    private static final double DEFAULT_AVERAGE_GRADE = 0D;

    private String name;
    private List<Double> gradesList = new ArrayList<>();
    private double averageGrade = DEFAULT_AVERAGE_GRADE;

    public Student(String name) {
        this.setName(name);
        this.gradesList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setGradesList(List<Double> gradesList) {
        this.gradesList = gradesList;
    }

    private void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null");
        } else {
            this.name = name;
        }
    }

    public void calculateAverageGrade() {
        double average = 0D;
        for (Double grade : gradesList) {
            average += grade;
        }
        this.averageGrade = (average / this.gradesList.size());
    }

    @Override
    public int compareTo(Student o) {
        int result;
        if ( (result = this.name.compareTo(o.name)) != 0 ) return result;
        return Double.compare(o.averageGrade, this.averageGrade);
    }
}
