package models;

import models.Interfaces.ITeacher;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "teacher")
public class Teacher extends Person implements ITeacher {

    private String email;
    private Double salaryPerHour;
    private Set<Course> courses;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String phoneNumber, String email, Double salaryPerHour) {
        super(firstName, lastName, phoneNumber);
        this.setEmail(email);
        this.setSalaryPerHour(salaryPerHour);
    }

    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "salary_per_hour")
    public Double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(Double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    @OneToMany(mappedBy = "teacher", targetEntity = Course.class)
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
