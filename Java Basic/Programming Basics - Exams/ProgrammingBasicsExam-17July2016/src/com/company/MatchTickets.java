package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MatchTickets {
    public static final String asdasd = "####.##";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat(asdasd);

        double budget = Double.parseDouble(scanner.nextLine()); // [1 000...1 000 000]
        String normalVip = scanner.nextLine().toLowerCase();    // vip = 499.99    normal = 249.99
        int amountPeople = Integer.parseInt(scanner.nextLine());

        double forTransport = 0.00;

        if ((budget >= 1000 && budget <= 1000000) && ("vip".equals(normalVip) || "normal".equals(normalVip))) {

            if (amountPeople >= 1 && amountPeople <= 4) {
                forTransport = budget * 0.75;
            } else if (amountPeople >= 5 && amountPeople <= 9) {
                forTransport = budget * 0.6;
            } else if (amountPeople >= 10 && amountPeople <= 24) {
                forTransport = budget * 0.5;
            } else if (amountPeople >= 25 && amountPeople <= 49) {
                forTransport = budget * 0.4;
            } else if (amountPeople >= 50) {
                forTransport = budget * 0.25;
            }
            if ("vip".equals(normalVip)) {
                double sum = budget - forTransport;
                double price = amountPeople * 499.99;
                if (price <= sum) {
                    System.out.printf("Yes! You have %.2f leva left.",(sum-price));
                } else if (price > sum) {
                    System.out.printf("Not enough money! You need %.2f leva.",(price-sum));
                }
            } else if ("normal".equals(normalVip)){
                double sum = budget - forTransport;
                double price = amountPeople * 249.99;
                if (price <= sum) {
                    System.out.printf("Yes! You have %.2f leva left.",(sum-price));
                } else if (price > sum) {
                    System.out.printf("Not enough money! You need %.2f leva.",(price-sum));
                }
            }
        }

    }
}
