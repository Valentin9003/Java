package com.example.automapping.service.employeeService;

import com.example.automapping.model.Employee;
import com.example.automapping.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public void registerEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findByBirthDateBefore(Date birthDate) {
        return this.employeeRepository.findByBirthdayBeforeOrderBySalaryDesc(birthDate);
    }
}
