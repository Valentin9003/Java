package com.company;

import java.util.Scanner;

public class Functions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int br = 0;

        for (int i = 1; i <= 30 ; i++) {
            for (int j = 1; j <= 30 ; j++) {
                for (int k = 1; k < 30; k++) {

                    if ((i + j + k == n) && (i < j) && (i < k) && (j < k)) {
                        System.out.println(i + " + " + j + " + " + k  + " = " + ( i + j + k) );
                        br++;
                    }
                    if ((i * j * k == n) && (i > j) && (i > k) && (j > k)) {
                        System.out.println(i + " * " + j + " * " + k  + " = " + ( i * j * k) );
                        br++;
                    }
                }
            }
        }
        if (br == 0) {
            System.out.println("No!");
        }
    }
}
