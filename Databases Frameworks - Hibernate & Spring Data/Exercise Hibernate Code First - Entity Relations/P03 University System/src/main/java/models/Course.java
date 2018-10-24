package models;

import models.Interfaces.ICourse;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course implements ICourse {

    private Integer id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer credits;
    private Set<Student> students;
    private Teacher teacher;

    public Course() {
    }

    public Course(String name, String description, Integer credits) {
        this.setName(name);
        this.setDescription(description);
        this.startDate = LocalDate.now();
        this.setCredits(credits);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "start_date")
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Basic
    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @ManyToMany
    @JoinTable(name = "courses_students",
    joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id" ),
    inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            foreignKey = @ForeignKey(name = "FK_cs_course"),
            inverseForeignKey = @ForeignKey(name = "FK_cs_student"))
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @ManyToOne(targetEntity = Teacher.class)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_course_teacher"))
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
