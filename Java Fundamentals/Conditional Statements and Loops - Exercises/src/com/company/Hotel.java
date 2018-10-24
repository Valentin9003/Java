package com.company;

import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();  // – May, June, July, August, September, October or December
        int nightsCount = Integer.parseInt(scanner.nextLine());

        double studioPrice = 0.0;
        double doubleRoom = 0.0;
        double masterSuite = 0.0;

        double discountStudio = 0.0;
        double discountDouble = 0.0;
        double discountMaster = 0.0;

        switch (month) {
            case "May":
                if (nightsCount > 7) {
                    studioPrice += (50 * 0.95) * nightsCount;
                    doubleRoom += 65 * nightsCount;
                    masterSuite += 75 * nightsCount;
                } else {
                    studioPrice += 50 * nightsCount;
                    doubleRoom += 65 * nightsCount;
                    masterSuite += 75 * nightsCount;
                }
                break;
            case "October":
                if (nightsCount > 7) {
                    studioPrice += (50 * 0.95) * (nightsCount - 1);
                    doubleRoom += 65 * nightsCount;
                    masterSuite += 75 * nightsCount;
                } else {
                    studioPrice += 50 * nightsCount;
                    doubleRoom += 65 * nightsCount;
                    masterSuite += 75 * nightsCount;
                }
                break;
            case "June":
                if (nightsCount > 14) {
                    studioPrice += 60 * nightsCount;
                    doubleRoom += (72 * 0.9) * nightsCount;
                    masterSuite += 82 * nightsCount;
                } else {
                    studioPrice += 60 * nightsCount;
                    doubleRoom += 72 * nightsCount;
                    masterSuite += 82 * nightsCount;
                }
                break;
            case "September":
                if (nightsCount > 14) {
                    studioPrice += 60 * (nightsCount - 1);
                    doubleRoom += (72 * 0.9) * nightsCount;
                    masterSuite += 82 * nightsCount;
                } else if (nightsCount > 7 ) {
                    studioPrice += 60 * (nightsCount - 1);
                    doubleRoom += 72 * nightsCount;
                    masterSuite += 82 * nightsCount;
                } else {
                    studioPrice += 60 * nightsCount;
                    doubleRoom += 72 * nightsCount;
                    masterSuite += 82 * nightsCount;
                }
                break;
            case "July":
            case "August":
            case "December":
                if (nightsCount > 14) {
                    studioPrice += 68 * nightsCount;
                    doubleRoom += 77 * nightsCount;
                    masterSuite += (89 * 0.85) * nightsCount;
                } else {
                    studioPrice += 68 * nightsCount;
                    doubleRoom += 77 * nightsCount;
                    masterSuite += 89 * nightsCount;
                }
                break;
        }

        System.out.printf("Studio: %.2f lv.%n", studioPrice);
        System.out.printf("Double: %.2f lv.%n", doubleRoom);
        System.out.printf("Suite: %.2f lv.%n", masterSuite);
    }
}

