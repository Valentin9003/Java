package com.example.automapping;


import com.example.automapping.dto.EmployeeDto;
import com.example.automapping.dto.ManagerDto;
import com.example.automapping.model.Address;
import com.example.automapping.model.City;
import com.example.automapping.model.Employee;
import com.example.automapping.service.addressService.AddressService;
import com.example.automapping.service.cityService.CityService;
import com.example.automapping.service.employeeService.EmployeeService;
import com.example.automapping.util.DtoConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
@Transactional
public class TerminalRunner implements CommandLineRunner {

    private EmployeeService employeeService;
    private CityService cityService;
    private AddressService addressService;

    @Autowired
    public TerminalRunner(EmployeeService employeeService, CityService cityService, AddressService addressService) {
        this.employeeService = employeeService;
        this.cityService = cityService;
        this.addressService = addressService;
    }

    @Override
    public void run(String... args) throws Exception {

        simpleMapping();
        advancedMapping();
        projection();
    }

    private void projection() throws ParseException {
        /**
         * Use Hibernate to create and insert into a database list of employees that each
         * employee has first name, last name, salary, birthday, address and manager
         * (another employee). Transform to EmployeeDto (first name, last name, salary,
         * manager’s last name) those employees who are born before 1990. Order them by
         * salary descending and print them on the console.
         */

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        persistDataIntoDB(sdf);

        List<Employee> olderEmployees =
                employeeService.findByBirthDateBefore(sdf.parse("1990-01-01"));

        List<EmployeeDto> olderEmployeeDtoList =
                DtoConvertUtil.convertEmployeeList(olderEmployees, EmployeeDto.class);

        System.out.println(olderEmployeeDtoList);
    }

    private void persistDataIntoDB(SimpleDateFormat sdf) throws ParseException {
        Address address = new Address("street Great Gorko", new City("Plovdiv"));
        Address address1 = new Address("Pere Toshev", new City("Sofia"));
        Address address2 = new Address("str. TamNqkade", new City("Varna"));

        Employee empl0 =
                new Employee("Georgy", "Stamov", BigDecimal.valueOf(4321.50), sdf.parse("1987-12-17"), false, address);
        Employee empl1 =
                new Employee("Pesho", "Panov", BigDecimal.valueOf(3242.50), sdf.parse("1975-06-01"), false, address1);
        Employee empl2 =
                new Employee("Rado", "Dimitrov", BigDecimal.valueOf(2000.00), sdf.parse("1980-02-18"), false, address2);

        empl0.addManagedEmployee(empl1);
        empl1.setManager(empl0);
        empl1.addManagedEmployee(empl2);
        empl2.setManager(empl1);

        this.employeeService.registerEmployee(empl2);
    }

    private void advancedMapping() {
        /** 2.Advanced Mapping
           Create class Employee with properties first name, last name, birthday, salary,
           information about whether the employee is on holiday, address, manager
           (another employee) and list of employees that he is in charge of.
           Create 2 types of data transfer objects – employee data transfer object and
           manager data transfer object.
                • EmployeeDto – first name, last name, salary
                • ManagerDto – first name, last name, list of EmployeeDtos that he/she is
                    in charge of and their count
           Create a list of several employees then transform it to list of ManagerDtos
           and print it on the console in the format provided below:
            {ManagerFirstName} {ManagerLastName} | Employees: {EmployeesCount}
                - {EmployeeFirstName} {EmployeeLastName} {EmployeeSalary} */

        System.out.println("-- -- -- ADVANCED MAPPING RESULT -- -- --");

        Employee empl0 = new Employee("Georgy", "Stamov", BigDecimal.valueOf(4321.50));
        Employee empl1 = new Employee("Pesho", "Panov", BigDecimal.valueOf(3242.50));
        Employee empl2 = new Employee("Rado", "Dimitrov", BigDecimal.valueOf(2000.00));
        empl0.addManagedEmployee(empl1);
        empl0.addManagedEmployee(empl2);

        ManagerDto managerDto =
                DtoConvertUtil.convert(empl0, ManagerDto.class);
        System.out.println(managerDto);

        System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- --");
    }

    private void simpleMapping() {
        /** 1.Simple Mapping
            Create class Employee that has properties first name, last name, salary,
            birthday and address. Create EmployeeDto class that will keep synthesized
            information about instances of Employee class (only first name, last name
            and salary). Create an instance of employee object and use the ModelMapper
            to map the newly created Employee to object of type EmployeeDto.*/

        System.out.println("-- -- -- SIMPLE MAPPING RESULT -- -- --");

        Employee empl =
                new Employee("Georgy", "Goshev", BigDecimal.valueOf(1231.50));

        //Convert from Employee to DTO
        EmployeeDto emplDto =
                DtoConvertUtil.convert(empl, EmployeeDto.class);
        System.out.println(emplDto);

        //Transfer from DTO to Employee
        Employee employee =
                DtoConvertUtil.convert(emplDto, Employee.class);
        System.out.println(employee); //TODO -> @Override toString() on Employee

        System.out.println("-- -- -- -- -- -- -- -- -- --  -- -- --");

    }

}
