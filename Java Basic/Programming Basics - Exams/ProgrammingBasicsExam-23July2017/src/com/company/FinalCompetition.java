package com.company;

import java.util.Scanner;

public class FinalCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int brDancer = Integer.parseInt(scanner.nextLine());
        double points = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String place = scanner.nextLine();
        double money = 0.00;

        switch (season){
            case "summer":
                switch (place) {
                    case "Bulgaria":
                        money += (brDancer * points) - ((brDancer * points) * 0.05);
                        break;
                    case "Abroad":
                        money += (brDancer * points) + (brDancer * points) * 0.5; //- ((brDancer * points) * 0.1);
                        money -= (money * 0.1);
                        break;
                }
                break;
            case "winter":
                switch (place) {
                    case "Bulgaria":
                        money += (brDancer * points) - (((brDancer * points) * 0.08));
                        break;
                    case "Abroad":
                        money += (brDancer * points) + (brDancer * points) * 0.5; // - ((brDancer * points) * 0.15);
                        money -= (money * 0.15);
                        break;
                }
                break;
        }
        double giving = money * 0.75;
        double sum = money - giving;
        double moneyPerDamcer = sum / (double)(brDancer);

        System.out.printf("Charity - %.2f%n", giving);
        System.out.printf("Money per dancer - %.2f", moneyPerDamcer);
    }
}
