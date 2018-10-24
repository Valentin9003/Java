package com.company;

import java.util.Scanner;

public class GrapeAndRakia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double area = Double.parseDouble(scanner.nextLine());
        double kgPerOneArea = Double.parseDouble(scanner.nextLine());
        double notGood = Double.parseDouble(scanner.nextLine());

        double production = (area * kgPerOneArea) - notGood;

        double rakia = (production * 0.45) / 7.5;
        double winMoneyRakia = rakia * 9.8;

        double forSale = (production * 0.55) * 1.5;

        System.out.printf("%.2f%n", winMoneyRakia);
        System.out.printf("%.2f", forSale);
    }
}
