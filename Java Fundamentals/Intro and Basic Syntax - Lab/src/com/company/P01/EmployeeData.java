package com.company.P01;

import java.text.DecimalFormat;
import java.util.Scanner;

public class EmployeeData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("00000000");

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        int employeeID = Integer.parseInt(scanner.nextLine());
        double salary = Double.parseDouble(scanner.nextLine());

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Employee ID: " + df.format(employeeID));
        System.out.printf("Salary: %.2f", salary );
    }
}
