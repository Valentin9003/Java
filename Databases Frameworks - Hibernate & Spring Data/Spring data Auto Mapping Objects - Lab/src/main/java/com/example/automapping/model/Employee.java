package com.example.automapping.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "employees")
public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private Date birthday;
    private Boolean isOnHoliday;
    private Address address;
    private Employee manager;
    private Set<Employee> managedEmployees;

    public Employee() {
        managedEmployees = new HashSet<>();
    }

    public Employee(String firstName, String lastName, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.managedEmployees = new HashSet<>();
    }

    public Employee(String firstName, String lastName, BigDecimal salary, Date birthday, Boolean isOnHoliday, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthday = birthday;
        this.isOnHoliday = isOnHoliday;
        this.address = address;
        this.managedEmployees = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(nullable = false)
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Basic
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Column(name = "is_on_holiday")
    public Boolean getOnHoliday() {
        return isOnHoliday;
    }

    public void setOnHoliday(Boolean onHoliday) {
        isOnHoliday = onHoliday;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Employee.class)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, targetEntity = Employee.class)
    public Set<Employee> getManagedEmployees() {
        return managedEmployees;
    }

    public void setManagedEmployees(Set<Employee> managedEmployees) {
        this.managedEmployees = managedEmployees;
    }

    public void addManagedEmployee(Employee empl) {
        this.managedEmployees.add(empl);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                ", isOnHoliday=" + isOnHoliday +
                ", address=" + address +
                ", manager=" + manager +
                ", managedEmployees=" + managedEmployees +
                '}';
    }
}
