package com.company;

import java.util.Scanner;

public class Problem01Distance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstSpeed = Double.parseDouble(scanner.nextLine());
        double firstTime = Double.parseDouble(scanner.nextLine());
        double secondTime = Double.parseDouble(scanner.nextLine());
        double thirdtime = Double.parseDouble(scanner.nextLine());

        double firstTimeH = firstTime / 60;
        double secondTimeH = secondTime / 60;
        double thirdtimeH = thirdtime / 60;

        double firstKm = firstSpeed * firstTimeH;
        double brSpeed = firstSpeed + firstSpeed * 0.1;
        double secondKm = secondTimeH * brSpeed;

        brSpeed -= brSpeed * 0.05;

        double thirdKm = thirdtimeH * brSpeed;

        brSpeed = firstKm + secondKm  +thirdKm;

        System.out.printf("%.2f", brSpeed);
    }
}
