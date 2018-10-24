package com.company;

import java.util.Scanner;

public class TailoringWorkshop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int brTable = Integer.parseInt(scanner.nextLine());
        double daljina = Double.parseDouble(scanner.nextLine());
        double shirochina = Double.parseDouble(scanner.nextLine());

        double sum = brTable * (daljina + 2 * 0.3) * (shirochina + 2 * 0.3);
        double area = brTable * (daljina / 2) * (daljina / 2);

        double priceUSD = sum * 7 + area * 9;
        double priceBGN = priceUSD * 1.85;

        System.out.printf("%.2f USD%n", priceUSD);
        System.out.printf("%.2f BGN%n", priceBGN);
    }
}
