package models;

import models.Interfaces.IStudent;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "student")
public class Student extends Person implements IStudent {

    private Double averageGrade;
    private String attendance; //посещаемост
    private Set<Course> courses;

    public Student() {
    }

    public Student(String firstName, String lastName, String phoneNumber, Double averageGrade, String attendance) {
        super(firstName, lastName, phoneNumber);
        this.setAverageGrade(averageGrade);
        this.setAttendance(attendance);
    }

    @Column(name = "average_grade")
    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Basic
    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    @ManyToMany(mappedBy = "students", targetEntity = Course.class)
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
