package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("00.00");

        int n = Integer.parseInt(scanner.nextLine());   // [1....1000]
        double br = 0.00;
        double br2 = 0.00;
        double br3 = 0.00;
        double br4 = 0.00;
        double br5 = 0.00;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (number < 200) {
                br++;
            } else if (number >= 200 && number <= 399) {
                br2++;
            } else if (number >= 400 && number <= 599) {
                br3++;
            } else if (number >= 600 && number <= 799) {
                br4++;
            } else if (number >= 800 ) {
                br5++;
            }
        }
        System.out.println(df.format(100 * br / n) + "%");
        System.out.println(df.format(100 * br2 / n) + "%");
        System.out.println(df.format(100 * br3 / n) + "%");
        System.out.println(df.format(100 * br4 / n) + "%");
        System.out.println(df.format(100 * br5 / n) + "%");
    }
}
