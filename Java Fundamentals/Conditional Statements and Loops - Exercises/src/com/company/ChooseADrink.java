package com.company;

import java.util.Scanner;

public class ChooseADrink {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String profession = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        if (profession.equals("Athlete"))
        {
            double sum = quantity * 0.70;
            System.out.printf("The %s has to pay %.0f%n.", profession, sum);
        }
        else if (profession.equals("Businessman") || profession.equals("Businesswoman"))
        {
            double sum = quantity * 1;
            System.out.printf("The %s has to pay %.0f%n.", profession, sum);
        }
        else if (profession.equals("SoftUni Student"))
        {
            double sum = quantity * 1.70;
            System.out.printf("The %s has to pay %.0f%n.", profession, sum);
        }
        else
        {
            double sum = quantity * 1.2;
            System.out.printf("The %s has to pay %.0f%n.", profession, sum);
        }
    }
}
