package p04_companyRoster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {

    private List<Employee> employees;

    public Department() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(this.employees);
    }

    public void addEmployees(Employee employees) {
        this.employees.add(employees);
    }
}
