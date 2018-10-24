package com.company;

import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());   //•	Наследените пари – реално число в интервала [1.00 ... 1 000 000.00]
        int yearToLive = Integer.parseInt(scanner.nextLine());   //•	Годината, до която трябва да живее (включително) – цяло число в интервала [1801 ... 1900]
        int yearsIvan = 18;
        int yearBack = 1800;

        //за всяка четна (1800, 1802 и т.н) година ще харчи 12 000 лева
        //За всяка нечетна (1801,1803  и т.н.) ще харчи 12 000 + 50 * [годините, които е навършил през дадената година].

        double moneyForEvenYear = 0;
        double moneyForOddYear = 0;

        for (int i = 1800; i <= yearToLive; i++) {
            if (i % 2 == 0) {
                moneyForEvenYear += 12000;
            } else if (i % 2 != 0) {
                moneyForOddYear += 12000 + 50 * (double)yearsIvan;
            }
            yearsIvan++;
        }

        double allMoney = moneyForEvenYear + moneyForOddYear;
        if (allMoney < money) {
            money -= allMoney;
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", money);
        } else if (allMoney >= money) {
            allMoney -= money;
            System.out.printf("He will need %.2f dollars to survive.", allMoney);
        }
    }
}
