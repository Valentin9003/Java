package com.company;

import java.util.Scanner;

public class CharacterStats {
    private static String print(String element, int count) {
        return new String(new char[count]).replace("\0", element);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int curentHealth = Integer.parseInt(scanner.nextLine());
        int maxHealth = Integer.parseInt(scanner.nextLine());
        int curentEnergy = Integer.parseInt(scanner.nextLine());
        int maxEnergy = Integer.parseInt(scanner.nextLine());

        int pointsHealth = maxHealth - curentHealth;
        int pointsEnergy = maxEnergy - curentEnergy;

        System.out.println("Name: " + name);
        System.out.printf("Health: |%s%s|%n",
                print("|", curentHealth),
                print(".", pointsHealth));

        System.out.printf("Energy: |%s%s|",
                print("|", curentEnergy),
                print(".", pointsEnergy));
    }
}
