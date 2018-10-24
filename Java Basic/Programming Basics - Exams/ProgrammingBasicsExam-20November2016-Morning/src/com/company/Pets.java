package com.company;

import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int food = Integer.parseInt(scanner.nextLine());
        double dogFoodPerDayKg = Double.parseDouble(scanner.nextLine());
        double catFoodPerDayKg = Double.parseDouble(scanner.nextLine());
        double turtleFoodPerDayGr = Double.parseDouble(scanner.nextLine());

        double allNeedFood = (dogFoodPerDayKg + catFoodPerDayKg + (turtleFoodPerDayGr / 1000)) * days;

        if (food < allNeedFood) {
            double result = Math.ceil(allNeedFood - food);
            System.out.printf("%.0f more kilos of food are needed.", result);
        } else {
            double result = Math.floor(food - allNeedFood);
            System.out.printf("%.0f kilos of food left.", result);
        }
    }
}
