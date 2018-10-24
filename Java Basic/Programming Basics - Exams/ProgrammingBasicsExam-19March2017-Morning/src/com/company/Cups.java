package com.company;

import java.util.Scanner;

public class Cups {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cups = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        int workingDays = Integer.parseInt(scanner.nextLine());

        int h = workers * workingDays * 8;
        double make = (double)(h / 5);
        double makeCups = Math.floor(make);

        if (makeCups >= cups) {
            System.out.printf("%.2f extra money",(makeCups - cups)*4.2 );
        } else {
            System.out.printf("Losses: %.2f",(cups - makeCups)*4.2 );
        }
    }
}
