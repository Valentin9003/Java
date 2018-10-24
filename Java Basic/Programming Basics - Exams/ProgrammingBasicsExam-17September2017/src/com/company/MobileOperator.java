package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MobileOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("####0.00");

        String timeContract = scanner.nextLine();    // “one”, или “two”
        String typeContract = scanner.nextLine();    // “Small”,  “Middle”, “Large”или “ExtraLarge”;
        String inputInternet = scanner.nextLine();   // - “yes”, или “no”
        int brMonths = Integer.parseInt(scanner.nextLine());         // [1....24]

        double tax = 0.0;

        switch (timeContract) {
            case "one":
                switch (typeContract) {
                    case "Small":
                        tax = 9.98;
                        break;
                    case "Middle":
                        tax = 18.99;
                        break;
                    case "Large":
                        tax = 25.98;
                        break;
                    case "ExtraLarge":
                        tax = 35.99;
                        break;
                }
                break;
            case "two":
                switch (typeContract) {
                    case "Small":
                        tax = 8.58;
                        break;
                    case "Middle":
                        tax = 17.09;
                        break;
                    case "Large":
                        tax = 23.59;
                        break;
                    case "ExtraLarge":
                        tax = 31.79;
                        break;
                }
                break;
        }

        if (inputInternet.equals("yes")) {
            if (tax <= 10 ){
                tax += 5.50;
            } else if (tax <= 30) {
                tax += 4.35;
            } else if (tax > 30) {
                tax += 3.85;
            }
        }
        if (timeContract.equals("two")) {
            tax = tax - tax * 0.0375;
        }

        if (timeContract.equals("one")) {
            tax *= brMonths;
        } else {
            tax *= brMonths;
        }

        System.out.printf("%.2f lv.", tax);
    }
}


