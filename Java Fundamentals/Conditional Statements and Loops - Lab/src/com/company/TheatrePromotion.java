package com.company;

import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfDay = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        if (age >= 0 && age <= 122) {

            switch (typeOfDay){
                case "Weekday":
                    if (age >= 0 && age <= 18) {
                        System.out.println("12$");
                    } else if (age > 18 && age <= 64) {
                        System.out.println("18$");
                    } else if (age > 64 && age <= 122) {
                        System.out.println("12$");
                    }
                    break;
                case "Weekend":
                    if (age >= 0 && age <= 18) {
                        System.out.println("15$");
                    } else if (age > 18 && age <= 64) {
                        System.out.println("20$");
                    } else if (age > 64 && age <= 122) {
                        System.out.println("15$");
                    }
                    break;
                case "Holiday":
                    if (age >= 0 && age <= 18) {
                        System.out.println("5$");
                    } else if (age > 18 && age <= 64) {
                        System.out.println("12$");
                    } else if (age > 64 && age <= 122) {
                        System.out.println("10$");
                    }
                    break;
            }

        } else {
            System.out.println("Error!");
        }
    }
}
