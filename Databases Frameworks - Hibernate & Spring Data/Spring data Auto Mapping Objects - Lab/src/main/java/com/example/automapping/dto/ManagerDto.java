package com.example.automapping.dto;

import java.util.Set;

public class ManagerDto {

    private String firstName;
    private String lastName;
    private Set<EmployeeDto> managedEmployees;

    public ManagerDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<EmployeeDto> getManagedEmployees() {
        return managedEmployees;
    }

    public void setManagedEmployees(Set<EmployeeDto> employeeDtos) {
        this.managedEmployees = employeeDtos;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append(String.format("%s %s | Employees: %d%n", 
               this.getFirstName(), this.getLastName(), this.getManagedEmployees().size()));
        for (EmployeeDto e : managedEmployees) {
            sb.append(String.format("   - %s %s %.2f%n",
                    e.getFirstName(), e.getLastName(), e.getSalary()));
        }
        return sb.toString();
    }
}
