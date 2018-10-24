package com.company;

import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int area = Integer.parseInt(scanner.nextLine());
        double kgFromDkr = Double.parseDouble(scanner.nextLine());
        int needLitreWine = Integer.parseInt(scanner.nextLine());
        int numberWorkers = Integer.parseInt(scanner.nextLine());

        double harvestForWine = (area * 0.4) * kgFromDkr;
        double wine = harvestForWine / 2.5;

        if (wine < needLitreWine) {
            System.out.printf( "It will be a tough winter! More %.0f liters wine needed.",Math.floor(needLitreWine - wine) );
        } else if (wine >= needLitreWine) {
            System.out.printf( "Good harvest this year! Total wine: %.0f liters.",Math.floor(wine) );
            System.out.println();
            System.out.printf("%.0f liters left -> %.0f liters per person.", Math.ceil(wine - needLitreWine), Math.ceil((wine - needLitreWine) / numberWorkers) );
        }
    }
}
