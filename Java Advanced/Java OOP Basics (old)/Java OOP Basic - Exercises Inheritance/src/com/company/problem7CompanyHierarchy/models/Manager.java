package com.company.problem7CompanyHierarchy.models;

import com.company.problem7CompanyHierarchy.interfaces.IManager;

import java.util.HashSet;
import java.util.Set;

public class Manager extends Employee implements IManager{

    private Set<Employee> employees;

    public Manager(String id, String firstName, String lastName, Department department, double salary, HashSet<Employee> employees) {
        super(id, firstName, lastName, department, salary);
        this.employees = new HashSet<>();
    }

    @Override
    public void addEmployees(HashSet<Employee> employees) {
        this.employees.addAll(employees);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "employees=" + employees +
                '}';
    }
}
