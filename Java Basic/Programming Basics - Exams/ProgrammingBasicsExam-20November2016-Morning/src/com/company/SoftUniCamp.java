package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SoftUniCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#0.00");

        int brGroups = Integer.parseInt(scanner.nextLine());

        double brCars = 0;
        double brBus = 0;
        double brSmallBus = 0;
        double brBigBus = 0;
        double brTrine = 0;
        double brAllPpl = 0;

        for (int i = 0; i < brGroups; i++) {

            int brPpl = Integer.parseInt(scanner.nextLine());
            brAllPpl += brPpl;

            if (brPpl <= 5) {
                brCars += brPpl;
            }
            if (brPpl >= 6 && brPpl <= 12) {
                brBus += brPpl;
            }
            if (brPpl >= 13 && brPpl <= 25) {
                brSmallBus += brPpl;
            }
            if (brPpl >= 26 && brPpl <= 40) {
                brBigBus += brPpl;
            }
            if (brPpl >= 41) {
                brTrine += brPpl;
            }

        }

        System.out.println(df.format(brCars / brAllPpl * 100) + "%");
        System.out.println(df.format(brBus / brAllPpl * 100) + "%");
        System.out.println(df.format(brSmallBus / brAllPpl * 100) + "%");
        System.out.println(df.format(brBigBus / brAllPpl * 100) + "%");
        System.out.println(df.format(brTrine / brAllPpl * 100) + "%");
    }
}
