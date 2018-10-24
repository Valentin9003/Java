package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class GameOFIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("###0.00");

        int n = Integer.parseInt(scanner.nextLine());
        double result = 0;
        double br1 = 0;
        double br2 = 0;
        double br3 = 0;
        double br4 = 0;
        double br5 = 0;
        double br6 = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (number >= 0 && number <= 9) {
                result += number * 0.2;
                br1++;
            } else if (number >= 10 && number <= 19) {
                result += number * 0.3;
                br2++;
            } else if (number >= 20 && number <= 29) {
                result += number * 0.4;
                br3++;
            } else if (number >= 30 && number <= 39) {
                result += 50;
                br4++;
            } else if (number >= 40 && number <= 50) {
                result += 100;
                br5++;
            } else {
                result /= 2;
                br6++;
            }
        }
        System.out.println(df.format(result));
        System.out.println("From 0 to 9: " + df.format(br1 / n * 100) + "%");
        System.out.println("From 10 to 19: " + df.format(br2 / n * 100) + "%");
        System.out.println("From 20 to 29: " + df.format(br3 / n * 100) + "%");
        System.out.println("From 30 to 39: " + df.format(br4 / n * 100) + "%");
        System.out.println("From 40 to 50: " + df.format(br5 / n * 100) + "%");
        System.out.println("Invalid numbers: " + df.format(br6 / n * 100) + "%");
    }
}
