package com.company.problem7CompanyHierarchy.models;

import com.company.problem7CompanyHierarchy.interfaces.IEmployee;

public class Employee extends Person implements IEmployee{

    private double salary;
    private Department department;

    public Employee(String id, String firstName, String lastName, Department department, double salary) {
        super(id, firstName, lastName);
        this.setDepartment(department);
        this.setSalary(salary);
    }


    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    private void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", department=" + department +
                '}';
    }
}
