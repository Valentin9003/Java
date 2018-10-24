package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("####0.00");

        double budget = Double.parseDouble(scanner.nextLine());
        while (budget < 10.00 || budget > 10000.00) {
            System.out.println("Wrong input Budget, try again:");
            budget = Double.parseDouble(scanner.nextLine());
        }

        String season = scanner.nextLine();

        String clas = " ";
        String model = "";
        double price = 0;

        if (budget <= 100) {
            clas = "Economy class";

            switch (season) {
                case "Summer":
                    model = "Cabrio";
                    price += budget * 0.35;
                    break;
                case "Winter":
                    model = "Jeep";
                    price += budget * 0.65;
                    break;
            }
        } else if (budget > 100 && budget <= 500) {
            clas = "Compact class";

            switch (season) {
                case "Summer":
                    model = "Cabrio";
                    price += budget * 0.45;
                    break;
                case "Winter":
                    model = "Jeep";
                    price += budget * 0.8;
                    break;
            }
        } else if (budget > 500){
            clas = "Luxury class";
            model = "Jeep";
            price += budget * 0.9;
        }
        System.out.println(clas);
        System.out.println(model + " - " + df.format(price));
    }
}
