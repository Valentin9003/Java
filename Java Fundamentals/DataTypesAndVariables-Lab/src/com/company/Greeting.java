package com.company;

import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        System.out.printf("Hello, %s %s. You are %d years old.", firstName, lastName, age);
    }
}
