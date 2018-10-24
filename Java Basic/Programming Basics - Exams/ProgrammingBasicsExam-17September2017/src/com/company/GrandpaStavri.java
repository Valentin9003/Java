package com.company;

import java.util.Scanner;

public class GrandpaStavri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());

        double allLiters  = 0.0;
        double allDegree  = 0.0;

        for (int i = 1; i <= days ; i++) {
            double liter = Double.parseDouble(scanner.nextLine());
            double degreeDay = Double.parseDouble(scanner.nextLine());

            allLiters += liter;
            allDegree += liter * degreeDay;
        }
        double degree = allDegree / allLiters;

        System.out.printf("Liter: %.2f%n", allLiters);
        System.out.printf("Degrees: %.2f%n", degree);

        if (degree < 38) {
            System.out.println("Not good, you should baking!");
        } else if (degree >= 38 && degree <= 42) {
            System.out.println("Super!");
        } else {
            System.out.println("Dilution with distilled water!");
        }
    }
}
