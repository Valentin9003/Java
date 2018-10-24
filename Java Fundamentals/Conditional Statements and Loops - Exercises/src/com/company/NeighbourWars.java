package com.company;

import java.util.Scanner;

public class NeighbourWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peshoDamage = Integer.parseInt(scanner.nextLine());
        int goshoDamage = Integer.parseInt(scanner.nextLine());

        int peshoHealth = 100;
        int goshoHealth = 100;
        int counter = 0;

        for (int i = 1; ; i++)
        {
            counter++;

            if (i % 2 != 0)
            {
                goshoHealth -= peshoDamage;

                if (goshoHealth > 0)
                {
                    System.out.printf("Pesho used Roundhouse kick and reduced Gosho to %d health.%n", goshoHealth);
                }
            }
            else
            {
                peshoHealth -= goshoDamage;

                if (peshoHealth > 0)
                {
                    System.out.printf("Gosho used Thunderous fist and reduced Pesho to %d health.%n", peshoHealth);
                }
            }

            if (peshoHealth <= 0 || goshoHealth <= 0) break;

            if (i % 3 == 0)
            {
                peshoHealth += 10;
                goshoHealth += 10;
            }
        }

        String winner = (peshoHealth > goshoHealth) ? "Pesho" : "Gosho";

        System.out.printf("%s won in %dth round.", winner, counter);
    }
}
