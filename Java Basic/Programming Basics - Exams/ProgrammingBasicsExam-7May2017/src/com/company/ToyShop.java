package com.company;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double excursionPrice = Double.parseDouble(scanner.nextLine());
        int brPazel = Integer.parseInt(scanner.nextLine());
        int brSpeakToy = Integer.parseInt(scanner.nextLine());
        int brBears = Integer.parseInt(scanner.nextLine());
        int brMinions = Integer.parseInt(scanner.nextLine());
        int brTrucks = Integer.parseInt(scanner.nextLine());

        int all = brPazel + brSpeakToy + brBears + brMinions + brTrucks;
        double sum = brPazel * 2.6 + brSpeakToy * 3 + brBears * 4.1 + brMinions * 8.2 + brTrucks * 2;

        if (all >= 50){
            sum -= sum * 0.25;
            sum -= sum * 0.1;
        } else {
            sum -= sum * 0.1;
        }

        if (sum >= excursionPrice){
            System.out.printf("Yes! %.2f lv left.", sum - excursionPrice);
        }else {
            System.out.printf("Not enough money! %.2f lv needed.", excursionPrice - sum);
        }
    }
}
