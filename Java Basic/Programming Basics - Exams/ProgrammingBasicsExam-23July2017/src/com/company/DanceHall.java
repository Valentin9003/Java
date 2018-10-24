package com.company;

import java.util.Scanner;

public class DanceHall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double l = Double.parseDouble(scanner.nextLine());
        double w = Double.parseDouble(scanner.nextLine());
        double a = Double.parseDouble(scanner.nextLine());

        double sizeInSm = (l * 100) * (w * 100);
        double sizeGard = (a * 100) * (a * 100);
        double sizePeika = sizeInSm / 10;
        double freeSize = sizeInSm - (sizeGard + sizePeika);
        double stillSpace = freeSize / (40 + 7000);

        System.out.printf("%.0f",Math.floor(stillSpace));

    }
}
