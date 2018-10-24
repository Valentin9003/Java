package com.company;

import java.util.Scanner;

public class TradeComissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        double sells = Double.parseDouble(scanner.nextLine());

        double comision = -1;

        if (town.equals("Sofia")) {
            if ( 0 <= sells && sells <= 500) {
                comision = sells * 0.05;
            } else if (500 < sells && sells <= 1000) {
                comision = sells * 0.07;
            } else if (1000 < sells && sells <= 10000) {
                comision = sells * 0.08;
            } else if (sells > 10000) {
                comision = sells * 0.12;
            }
        } else if (town.equals("Varna")) {
            if ( 0 <= sells && sells <= 500) {
                comision = sells * 0.045;
            } else if (500 < sells && sells <= 1000) {
                comision = sells * 0.075;
            } else if (1000 < sells && sells <= 10000) {
                comision = sells * 0.1;
            } else if (sells > 10000) {
                comision = sells * 0.13;
            }
        } else if (town.equals("Plovdiv")) {
            if ( 0 <= sells && sells <= 500) {
                comision = sells * 0.055;
            } else if (500 < sells && sells <= 1000) {
                comision = sells * 0.08;
            } else if (1000 < sells && sells <= 10000) {
                comision = sells * 0.12;
            } else if (sells > 10000) {
                comision = sells * 0.145;
            }
        }
        if (comision > 0) {
            System.out.printf("%.2f", comision);
        } else {
            System.out.println("error");
        }
    }
}
