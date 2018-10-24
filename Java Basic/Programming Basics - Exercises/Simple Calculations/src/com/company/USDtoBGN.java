package com.company;

import java.util.Scanner;

public class USDtoBGN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double usd = Double.parseDouble(scanner.nextLine());
        double kurs = 1.79549;
        double bgn = usd*kurs;

        System.out.printf("%.2f BGN",bgn);
    }
}
