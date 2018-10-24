package com.company;

import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double amount = 0;
        double price = -1;

        if ("saturday".equalsIgnoreCase(dayOfWeek) || "sunday".equalsIgnoreCase(dayOfWeek)) {
            if (fruit.equalsIgnoreCase("banana")) {
                price = 2.7;
            } else if (fruit.equalsIgnoreCase("apple")) {
                price = 1.25;
            } else if (fruit.equalsIgnoreCase("orange")) {
                price = 0.9;
            } else if (fruit.equalsIgnoreCase("grapefruit")) {
                price = 1.6;
            } else if (fruit.equalsIgnoreCase("kiwi")) {
                price = 3.00;
            } else if (fruit.equalsIgnoreCase("pineapple")) {
                price = 5.6;
            } else if (fruit.equalsIgnoreCase("grapes")) {
                price = 4.2;
            }
        }
        else if ("monday".equalsIgnoreCase(dayOfWeek) || "tuesday".equalsIgnoreCase(dayOfWeek)
                || "wednesday".equalsIgnoreCase(dayOfWeek) || "thursday".equalsIgnoreCase(dayOfWeek)
                || "friday".equalsIgnoreCase(dayOfWeek)) {
            if (fruit.equalsIgnoreCase("banana")) {
                price = 2.5;
            } else if (fruit.equalsIgnoreCase("apple")) {
                price = 1.2;
            } else if (fruit.equalsIgnoreCase("orange")) {
                price = 0.85;
            } else if (fruit.equalsIgnoreCase("grapefruit")) {
                price = 1.45;
            } else if (fruit.equalsIgnoreCase("kiwi")) {
                price = 2.7;
            } else if (fruit.equalsIgnoreCase("pineapple")) {
                price = 5.5;
            } else if (fruit.equalsIgnoreCase("grapes")) {
                price = 3.85;
            }
        }
        amount = quantity * price;
        if (price > 0) {
            System.out.printf("%.2f", amount);
        } else {
            System.out.println("error");
        }
    }
}
