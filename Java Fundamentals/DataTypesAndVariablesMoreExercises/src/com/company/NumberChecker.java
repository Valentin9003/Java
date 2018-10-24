package com.company;

import java.util.Scanner;

public class NumberChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());

        // dirty way :p to find isInteger or isFloatingPoint
        if (number == (int)number) {
            System.out.println("integer");
        } else {
            System.out.println("floating-point");
        }
    }
}
