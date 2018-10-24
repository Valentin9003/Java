package com.company;

import java.util.Scanner;

public class bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int months = Integer.parseInt(scanner.nextLine());

        double electric = 0.00;
        double water = 0.00;
        double internet = 0.00;
        double other = 0.00;

        for (int i = 1; i <= months ; i++) {
            double el = Double.parseDouble(scanner.nextLine());

            electric += el;
            water += 20;
            internet += 15;
            other += (el + 35) + (el + 35) * 0.2;
        }
        double avarage = (electric + water + internet + other) / months;

        System.out.printf("Electricity: %.2f lv%n", electric);
        System.out.printf("Water: %.2f lv%n", water);
        System.out.printf("Internet: %.2f lv%n", internet);
        System.out.printf("Other: %.2f lv%n", other);
        System.out.printf("Average: %.2f lv%n", avarage);

    }
}
