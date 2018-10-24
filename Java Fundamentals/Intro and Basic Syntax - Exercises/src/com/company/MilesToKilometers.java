package com.company;

import java.util.Scanner;

public class MilesToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double km = Double.parseDouble(scanner.nextLine());

        double miles = km * 1.60934;

        System.out.printf("%.2f", miles);
    }
}
