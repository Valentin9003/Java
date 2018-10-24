package com.example.automapping.repository;

import com.example.automapping.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByBirthdayBeforeOrderBySalaryDesc(Date birthDate);
}
