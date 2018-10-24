package p04_companyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Department> departmentsDB = new HashMap<>();

        int amoutInputs = Integer.parseInt(reader.readLine());
        for (int i = 0; i < amoutInputs; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee empl = createNewEmployee(tokens, name, salary, position, department);
            fillDepartmentDB(departmentsDB, empl);
        }

        printResult(departmentsDB);
    }

    private static void printResult(Map<String,Department> departmentsDB) {
        departmentsDB.entrySet()
                .stream()
                .sorted((d1,d2) -> {
                    double d1AvgSalary = d1.getValue().getEmployees().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
                    double d2AvgSalary = d2.getValue().getEmployees().stream().mapToDouble(Employee::getSalary).average().getAsDouble();

                    if (d1AvgSalary == d2AvgSalary) {
                        return 0;
                    }
                    return d1AvgSalary > d2AvgSalary ? -1 : 1;
                })
                .limit(1)
                .forEach(depart -> {
                    System.out.println(String.format("Highest Average Salary: %s", depart.getKey()));
                    depart.getValue().getEmployees()
                            .stream()
                            .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
                            .forEach(System.out::println);
                });

    }

    private static void fillDepartmentDB(Map<String,Department> departmentsDB, Employee empl) {
        if (departmentsDB.containsKey(empl.getDepartment())) {
            departmentsDB.get(empl.getDepartment()).addEmployees(empl);
        } else {
            departmentsDB.putIfAbsent(empl.getDepartment(), new Department());
            departmentsDB.get(empl.getDepartment()).addEmployees(empl);
        }
    }

    private static Employee createNewEmployee(String[] tokens, String name, double salary, String position, String department) {
        Employee empl = null;
        switch (tokens.length){
            case 4:
                empl = new Employee(name, salary, position, department);
                break;
            case 5:
                try {
                    int age = Integer.parseInt(tokens[4]);
                    empl = new Employee(name, salary, position, department, age);
                } catch (NumberFormatException nfe) {
                    String email = tokens[4];
                    empl = new Employee(name, salary, position, department, email);
                }
                break;
            case 6:
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                empl = new Employee(name, salary, position, department, email, age);
                break;
        }
        return empl;
    }
}
