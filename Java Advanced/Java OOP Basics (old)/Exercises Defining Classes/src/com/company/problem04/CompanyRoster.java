package com.company.problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class CompanyRoster {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Double> departmentWithSalary = new HashMap<>();
        HashMap<String, TreeSet<Employee>> departmentWithEmployee = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] params = reader.readLine().split("\\s+");
            String name = params[0];
            double salary = Double.parseDouble(params[1]);
            String position = params[2];
            String department = params[3];

            Employee employee = null;
            if (params.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (params.length == 5) {
                if (isNumber(params[4])) {
                    int age = Integer.parseInt(params[4]);
                    employee = new Employee(name, salary, position, department, age);
                } else {
                    String email = params[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            } else {
                String email = params[4];
                int age = Integer.parseInt(params[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }

            if (!departmentWithEmployee.containsKey(department)) {
                departmentWithEmployee.put(department, new TreeSet<>());
                departmentWithSalary.put(department, 0.0);
            }
            departmentWithEmployee.get(department).add(employee);
            double valueNew = departmentWithSalary.get(department) + salary;
            departmentWithSalary.replace(department, valueNew);
        }

        Map.Entry<String, TreeSet<Employee>> best =
                departmentWithEmployee.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(departmentWithSalary.get(e2.getKey()), departmentWithSalary.get(e1.getKey())))
                .findFirst().get();

        System.out.printf("Highest Average Salary: %s%n", best.getKey());
        for (Employee employee : best.getValue()) {
            System.out.println(employee);
        }
    }

    private static boolean isNumber(String param) {
        try {
            Integer.parseInt(param);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
