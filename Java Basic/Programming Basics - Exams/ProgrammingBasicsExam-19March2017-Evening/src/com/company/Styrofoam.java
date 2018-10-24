package com.company;

import java.util.Scanner;

public class Styrofoam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double areaHouse = Double.parseDouble(scanner.nextLine());
        int brWindows = Integer.parseInt(scanner.nextLine());
        double onePackStyrofoam = Double.parseDouble(scanner.nextLine());
        double priceForOnePackStyrofoam = Double.parseDouble(scanner.nextLine());

        double allArea = (areaHouse - brWindows * 2.4) + ((areaHouse - brWindows * 2.4) * 0.1);
        allArea /= onePackStyrofoam;
        double needMoney = Math.ceil(allArea) * priceForOnePackStyrofoam;

        if (budget >= needMoney) {
            System.out.printf("Spent: %.2f%n", needMoney);
            System.out.printf("Left: %.2f", budget - needMoney);
        } else {
            System.out.printf("Need more: %.2f", needMoney - budget);
        }
    }
}
