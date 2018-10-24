package com.company;

import java.util.Scanner;

public class VaporStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        double totalSpend = 0;
        String gameName = scanner.nextLine();

        while (!gameName.equals("Game Time")) {

            int br = 0;
            switch (gameName){
                case "OutFall 4":
                    if (currentBalance >= 39.99) {
                        System.out.printf("Bought %s%n", gameName );
                        currentBalance -= 39.99;
                        totalSpend += 39.99;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    br++;
                    break;
                case "CS: OG":
                    if (currentBalance >= 15.99) {
                        System.out.printf("Bought %s%n", gameName );
                        currentBalance -= 15.99;
                        totalSpend += 15.99;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    br++;
                    break;
                case "Zplinter Zell":
                    if (currentBalance >= 19.99) {
                        System.out.printf("Bought %s%n", gameName );
                        currentBalance -= 19.99;
                        totalSpend += 19.99;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    br++;
                    break;
                case "Honored 2":
                    if (currentBalance >= 59.99) {
                        System.out.printf("Bought %s%n", gameName );
                        currentBalance -= 59.99;
                        totalSpend += 59.99;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    br++;
                    break;
                case "RoverWatch":
                    if (currentBalance >= 29.99) {
                        System.out.printf("Bought %s%n", gameName );
                        currentBalance -= 29.99;
                        totalSpend += 29.99;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    br++;
                    break;
                case "RoverWatch Origins Edition":
                    if (currentBalance >= 39.99) {
                        System.out.printf("Bought %s%n", gameName );
                        currentBalance -= 39.99;
                        totalSpend += 39.99;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    br++;
                    break;
            }
            if (br == 0) {
                System.out.println("Not Found");
            }
            gameName = scanner.nextLine();
        }
        if (currentBalance == 0) {
            System.out.println("Out of money!");
        } else {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpend, currentBalance );
        }
    }
}
