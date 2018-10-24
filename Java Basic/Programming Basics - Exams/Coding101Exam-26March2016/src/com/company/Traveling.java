package com.company;

import java.util.Scanner;

public class Traveling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine().toLowerCase();
        double lasteMoney = 0.00;
        String where = "";
        String campHotel = "";

        if (budget >= 10 && budget <= 5000) {

            if (budget <= 100) {
                where = "Somewhere in Bulgaria";
                switch (season) {
                    case "summer":
                        lasteMoney = budget * 0.3;
                        campHotel = "Camp";
                        break;
                    case "winter":
                        lasteMoney = budget * 0.7;
                        campHotel = "Hotel";
                        break;
                }

            } else if (budget <= 1000) {
                where = "Somewhere in Balkans";
                switch (season) {
                    case "summer":
                        lasteMoney = budget * 0.4;
                        campHotel = "Camp";
                        break;
                    case "winter":
                        lasteMoney = budget * 0.8;
                        campHotel = "Hotel";
                        break;
                }
            } else if (budget > 1000) {
                where = "Somewhere in Europe";
                campHotel = "Hotel";
                lasteMoney = budget * 0.9;
            }
        }
        System.out.println(where);
        System.out.printf("%s - %.2f ",campHotel,lasteMoney);
    }
}
