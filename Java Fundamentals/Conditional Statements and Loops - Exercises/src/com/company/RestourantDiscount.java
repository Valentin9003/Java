package com.company;

import java.util.Scanner;

public class RestourantDiscount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupSize = Integer.parseInt(scanner.nextLine());
        String pack = scanner.nextLine();

        double price = 0.0;
        double sum = 0.0;
        String place = "";

        if (groupSize <= 50) {
            price += 2500;
            place = "Small Hall";
        } else if (groupSize > 50 && groupSize <= 100) {
            price += 5000;
            place = "Terrace";
        } else if (groupSize > 100 && groupSize <= 120) {
            price += 7500;
            place = "Great Hall";
        } else {
            System.out.println("We do not have an appropriate hall.");
            return;
        }

        switch (pack) {
            case "Normal":
                sum += (price + 500) - ((price + 500) * 0.05);
                break;
            case "Gold":
                sum += (price + 750) - ((price + 750) * 0.1);
                break;
            case "Platinum":
                sum += (price + 1000) - ((price + 1000) * 0.15);
                break;
        }
        double pricePerPersone = sum / groupSize;

        System.out.printf("We can offer you the %s%n", place);
        System.out.printf("The price per person is %.2f$", pricePerPersone);
    }
}
