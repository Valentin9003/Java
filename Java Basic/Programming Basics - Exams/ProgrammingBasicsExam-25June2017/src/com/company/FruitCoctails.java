package com.company;

import java.util.Scanner;

public class FruitCoctails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String size = scanner.nextLine();
        int brCoctails = Integer.parseInt(scanner.nextLine());
        double money = 0.00;

        switch (size) {
            case "small":
                switch (fruit) {
                    case "Watermelon": money += (2 * 56) * brCoctails;  break;
                    case "Mango": money += (2 * 36.66) * brCoctails; break;
                    case "Pineapple": money += (2 * 42.10) * brCoctails; break;
                    case "Raspberry": money += (2 * 20) * brCoctails; break;
                }
                break;
            case "big":
                switch (fruit) {
                    case "Watermelon": money += (5 * 28.7) * brCoctails;  break;
                    case "Mango": money += (5 * 19.6) * brCoctails; break;
                    case "Pineapple": money += (5 * 24.8) * brCoctails; break;
                    case "Raspberry": money += (5 * 15.2) * brCoctails; break;
                }
                break;
        }
        if (money > 1000) {
            double result = money * 0.5;
            System.out.printf("%.2f lv.", result);
            return;
        } else if (money >= 400 && money <= 1000) {
            double result = money - money * 0.15;
            System.out.printf("%.2f lv.", result);
            return;
        }
        System.out.printf("%.2f lv.", money);
    }
}
