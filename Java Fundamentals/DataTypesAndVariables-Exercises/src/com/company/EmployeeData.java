package com.company;

import java.util.Scanner;

public class EmployeeData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastname = scanner.nextLine();
        byte age = Byte.parseByte(scanner.nextLine());
        char gender = scanner.nextLine().charAt(0);
        long id = Long.parseLong(scanner.nextLine());
        long employeeNumber = Long.parseLong(scanner.nextLine());

        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastname);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Personal ID: " + id);
        System.out.println("Unique Employee number: " + employeeNumber);
    }
}
