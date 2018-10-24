package com.company;

import java.util.Scanner;

public class VegetablesStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceVegetables = Double.parseDouble(scanner.nextLine());
        double priceFruits = Double.parseDouble(scanner.nextLine());
        int kgVegetables = Integer.parseInt(scanner.nextLine());
        int kgFruits = Integer.parseInt(scanner.nextLine());

        if (priceFruits >= 0.00 && priceFruits <= 1000.00) {
            if (priceVegetables >= 0.00 && priceVegetables <= 1000.00) {
                if (kgFruits >= 0.00 && kgFruits <= 1000.00) {
                    if (kgVegetables >= 0.00 && kgVegetables <= 1000.00) {
                        double sum = (priceVegetables * kgVegetables) + (priceFruits * kgFruits);
                        sum = sum / 1.94;
                        System.out.println(sum);
                    }
                }
            }
        }
    }
}
