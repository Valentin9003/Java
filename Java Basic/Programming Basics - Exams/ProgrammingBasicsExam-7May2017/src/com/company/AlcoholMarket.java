package com.company;

import java.util.Scanner;

public class AlcoholMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double whiskeyPrice = Double.parseDouble(scanner.nextLine());
        double beerLiters = Double.parseDouble(scanner.nextLine());
        double wineLiters = Double.parseDouble(scanner.nextLine());
        double rakiaLiters = Double.parseDouble(scanner.nextLine());
        double whiskeyLiters = Double.parseDouble(scanner.nextLine());

        double rakiaPrice = whiskeyPrice/2;
        double winePrice = rakiaPrice - (rakiaPrice * 0.4);
        double beerPrice = rakiaPrice - (rakiaPrice * 0.8);

        double sum = whiskeyLiters * whiskeyPrice + beerLiters * beerPrice + wineLiters * winePrice + rakiaLiters * rakiaPrice;

        System.out.printf("%.2f", sum);
    }
}
