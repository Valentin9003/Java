package com.company;

import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String dayNight = scanner.nextLine();
        double price = 0;

        if (n >= 100) {         // Proverka za vlak - vlakyt e nai evtin, zatova pravi pyrvo proverka za nego
            price = n * 0.06;
            System.out.printf("Train - %.2f lv",price);
        }
        else if (n >= 20) {         // Proverka za avtobus - pravim q vtora zashtoto e po skyp ot vlak i po evtin ot taxi
            price = n * 0.09;
            System.out.printf("Bus - %.2f lv", price);
        }
        else if (n < 20) {
            if (dayNight.equalsIgnoreCase("day")) {           // Proverka za Taxi dnevna tarifa
                price = 0.70 + n * 0.79;
                System.out.printf("Taxi - %.2f lv", price);
            } else if (dayNight.equalsIgnoreCase("night")) {  // Proverka za Taxi noshtna tarifa
                price = 0.70 + n * 0.90;
                System.out.printf("Taxi - %.2f lv", price);
            }
        }

    }
}
