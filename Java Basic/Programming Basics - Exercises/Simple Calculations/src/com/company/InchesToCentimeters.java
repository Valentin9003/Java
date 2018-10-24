package com.company;

import java.util.Scanner;

public class InchesToCentimeters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input Inches = ");
        double inches = Double.parseDouble(scanner.nextLine());
        double sm = inches * 2.54;
        System.out.println("Centimeters = " + sm);
    }
}
