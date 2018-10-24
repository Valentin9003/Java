package com.company;

import java.util.Scanner;

public class GameOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int magicalNumber = Integer.parseInt(scanner.nextLine());
        int br = 0;
        int a = 0;
        int b = 0;
        int counter = 0;

        for (int i = n; i <= m ; i++) {
            for (int j = n; j <= m ; j++) {
                int sum = i + j;
                br++;
                if (sum == magicalNumber) {
                    a = i;
                    b = j;
                    counter++;
                }
            }
        }
        if (counter > 0) {
            System.out.printf("Number found! %d + %d = %d", a,b,a+b);
        } else {
            System.out.printf("%d combinations - neither equals %d", br, magicalNumber);
        }
    }
}
