package com.company;

import java.util.Scanner;

public class ExcellentOrNot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());

        if (a >= 5.50) {
            System.out.println("Excellent!");
        } else {
            System.out.println("Not Excellent.");
        }

    }
}
