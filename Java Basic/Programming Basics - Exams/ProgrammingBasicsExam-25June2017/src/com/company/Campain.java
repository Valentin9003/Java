package com.company;

import java.util.Scanner;

public class Campain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double days = Double.parseDouble(scanner.nextLine());
        double chiefs = Double.parseDouble(scanner.nextLine());
        double torti = Double.parseDouble(scanner.nextLine());
        double gofreti = Double.parseDouble(scanner.nextLine());
        double palachinki = Double.parseDouble(scanner.nextLine());

        double moneyPerDay =(torti * 45 + gofreti * 5.8 + palachinki * 3.2) * chiefs;
        double all = moneyPerDay * days;
        double result = all - (all * 1/8);
        System.out.printf("%.2f", result);
    }
}
