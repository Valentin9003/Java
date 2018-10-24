package com.example.automapping.service.employeeService;

import com.example.automapping.model.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeService {

    public void registerEmployee(Employee employee);

    public List<Employee> findByBirthDateBefore(Date birthDate);
}
