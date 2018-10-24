package com.company.problem7CompanyHierarchy.interfaces;

import com.company.problem7CompanyHierarchy.models.Employee;

import java.util.HashSet;
import java.util.Set;

public interface IManager {

    Set<Employee> employees = new HashSet<>();

    void addEmployees(HashSet<Employee> employees);

    String toString();
}
