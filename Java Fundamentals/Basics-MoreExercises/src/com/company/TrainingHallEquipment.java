package com.company;

import java.util.Scanner;

public class TrainingHallEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int numberOfItems = Integer.parseInt(scanner.nextLine());
        double subTotal = 0;

        for (int i = 1; i <= numberOfItems ; i++)
        {
            String itemName = scanner.nextLine();
            double itemPrice = Double.parseDouble(scanner.nextLine());
            int itemCount = Integer.parseInt(scanner.nextLine());

            if (itemCount == 1) {
                System.out.printf("Adding %d %s to cart.%n", itemCount, itemName);
            } else {
                System.out.printf("Adding %d %ss to cart.%n", itemCount, itemName);
            }
            subTotal += itemCount * itemPrice;
        }

        System.out.printf("Subtotal: $%.2f %n", subTotal);

        if (subTotal <= budget)
        {
            System.out.printf("Money left: $%.2f", (budget - subTotal));
        }
        else
            {
                System.out.printf("Not enough. We need $%.2f more.", (subTotal - budget));
            }
    }
}
