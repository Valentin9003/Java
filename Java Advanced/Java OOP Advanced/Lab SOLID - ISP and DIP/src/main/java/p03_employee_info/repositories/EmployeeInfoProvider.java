package p03_employee_info.repositories;

import p03_employee_info.models.Employee;
import p03_employee_info.contracts.Database;
import p03_employee_info.contracts.InfoProvider;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeInfoProvider implements InfoProvider {

    private Database database;

    public EmployeeInfoProvider(Database database) {
        this.database = database;
    }

    @Override
    public List<Employee> getEmployeesSortedByName() {
        return this.database.readEmployees().stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Employee> getEmployeesSortedBySalary() {
        return this.database.readEmployees().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());
    }
}
