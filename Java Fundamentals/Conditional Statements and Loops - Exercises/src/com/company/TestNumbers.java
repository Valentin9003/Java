package com.company;

import java.util.Scanner;

public class TestNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int stop = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int br = 0;

        for (int i = a; i >= 1 ; i--) {
            for (int j = 1; j <= b ; j++) {

                sum += 3 * (i * j);
                br++;

                if (sum >= stop) {
                    System.out.println(br + " combinations");
                    System.out.printf("Sum: %d >= %d", sum, stop);
                    return;
                }

            }
        }
        System.out.println(br + " combinations");
        System.out.printf("Sum: %d", sum);
    }
}
