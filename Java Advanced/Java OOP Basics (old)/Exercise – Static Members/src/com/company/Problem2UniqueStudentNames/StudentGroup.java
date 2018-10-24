package com.company.Problem2UniqueStudentNames;

import java.util.HashSet;
import java.util.Set;

public class StudentGroup {

    private Set<String> students;

    public StudentGroup() {
        this.students = new HashSet<>();
    }

    public void addStudent(Student student) {
        students.add(student.getName());
    }

    public Integer getCountOfUniqueNames() {
        return students.size();
    }

}
