package com.company;

import java.util.Scanner;

public class MoneyReward {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pasts = Integer.parseInt(scanner.nextLine());
        double moneyPerPoint = Double.parseDouble(scanner.nextLine());
        double brPoints = 0.00;

        for (int i = 1; i <= pasts ; i++) {
            int points = Integer.parseInt(scanner.nextLine());

            if ( i % 2 == 0) {
                points *= 2;
            }
            brPoints += points;
        }
        double money = moneyPerPoint * brPoints;
        System.out.printf("The project prize was %.2f lv.", money);
    }
}
