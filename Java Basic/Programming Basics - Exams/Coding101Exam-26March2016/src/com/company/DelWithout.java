package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DelWithout {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("00.00");

        int n = Integer.parseInt(scanner.nextLine());    // [1...1000]
        double p1 = 0.00;
        double p2 = 0.00;
        double p3 = 0.00;

        if (n >= 1 && n <= 1000) {

            for (int i = 0; i < n; i++) {
                int number = Integer.parseInt(scanner.nextLine());

                if (number % 2 == 0) {
                    p1++;
                }
                if (number % 3 == 0) {
                    p2++;
                }
                if (number % 4 == 0) {
                    p3++;
                }
            }
        }
        System.out.println(df.format(p1 * 100 / n) + "%");
        System.out.println(df.format(p2 * 100 / n) + "%");
        System.out.println(df.format(p3 * 100 / n) + "%");
    }
}
