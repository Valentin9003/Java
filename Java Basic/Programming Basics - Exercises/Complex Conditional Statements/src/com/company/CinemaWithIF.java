package com.company;

import java.util.Scanner;

public class CinemaWithIF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        int roll = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());

        if ("Premiere".equals(type)) {
            System.out.printf("%.2f leva",(double)(roll * col * 12));
        } else if ("Normal".equals(type)) {
            System.out.printf("%.2f leva",(double)(roll * col * 7.50));
        } else if ("Discount".equals(type)) {
            System.out.printf("%.2f leva",(double)(roll * col * 5));
        } else {
            System.out.println("Error input");
        }
    }
}
