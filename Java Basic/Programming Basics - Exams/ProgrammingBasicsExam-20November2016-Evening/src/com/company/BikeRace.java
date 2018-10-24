package com.company;

import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int brJunior = Integer.parseInt(scanner.nextLine());
        int brSenior = Integer.parseInt(scanner.nextLine());
        String trace = scanner.nextLine().toLowerCase();

        double money = 0.00;

        switch (trace) {
            case "trail":
                money += brJunior * 5.50 + brSenior * 7;
                break;
            case "cross-country":
                if ((brJunior + brSenior) < 50) {
                    money += brJunior * 8 + brSenior * 9.50;
                } else {
                    money += brJunior * (8 - 8 * 0.25) + brSenior * (9.50 - 9.50 * 0.25);
                }
                break;
            case "downhill":
                money += brJunior * 12.25 + brSenior * 13.75;
                break;
            case "road":
                money += brJunior * 20 + brSenior * 21.50;
                break;
        }
        money -= money * 0.05;
        System.out.printf("%.2f", money);
    }
}
