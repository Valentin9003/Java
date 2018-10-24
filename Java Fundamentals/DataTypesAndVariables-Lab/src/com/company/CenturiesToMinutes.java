package com.company;

import java.util.Scanner;

public class CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Centuries = ");
        int centuries = Integer.parseInt(scanner.nextLine());

        int years = centuries * 100;
        int days = (int)(years * 365.2422);  // year have 365 days, but we * 365.2422 because every 4th year --> February = 29 days
        int hours = days * 24;
        int minutes = hours * 60;

        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes", centuries, years, days, hours, minutes);
    }
}
