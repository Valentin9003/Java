package com.company;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String destination = "";
        String where = "";
        double money = 0;

        if (budget <= 1000) {
            where = "Camp";
            switch (season){
                case "Summer":
                    destination = "Alaska";
                    money += budget * 0.65;
                    break;
                case "Winter":
                    destination = "Morocco";
                    money += budget * 0.45;
                    break;
            }
        } else if (budget > 1000 && budget <= 3000) {
            where = "Hut";
            switch (season){
                case "Summer":
                    destination = "Alaska";
                    money += budget * 0.80;
                    break;
                case "Winter":
                    destination = "Morocco";
                    money += budget * 0.60;
                    break;
            }
        } else if (budget > 3000) {
            where = "Hotel";
            switch (season){
                case "Summer":
                    destination = "Alaska";
                    money += budget * 0.90;
                    break;
                case "Winter":
                    destination = "Morocco";
                    money += budget * 0.90;
                    break;
            }
        }
        System.out.printf("%s - %s - %.2f", destination, where, money);
    }
}
