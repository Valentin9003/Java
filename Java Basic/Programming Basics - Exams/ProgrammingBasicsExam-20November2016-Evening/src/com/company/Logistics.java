package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("###0.00");

        int n = Integer.parseInt(scanner.nextLine());

        int brBus =0;
        int brTruck = 0;
        int brTrine = 0;
        double allKg = 0;

        for (int i = 0; i < n; i++) {
            int ton = Integer.parseInt(scanner.nextLine());
            allKg += ton;

            if (ton <= 3) {
                brBus += ton;
            } else if (ton >= 4 && ton <= 11) {
                brTruck += ton;
            } else {
                brTrine += ton;
            }
        }
        double average = (brBus * 200 + brTruck * 175 + brTrine * 120) / allKg;
        double bus = brBus / allKg * 100;
        double truck = brTruck / allKg * 100;
        double trine = brTrine / allKg * 100;

        System.out.println(df.format(average));
        System.out.println(df.format(bus) + "%");
        System.out.println(df.format(truck) + "%");
        System.out.println(df.format(trine) + "%");
    }
}
