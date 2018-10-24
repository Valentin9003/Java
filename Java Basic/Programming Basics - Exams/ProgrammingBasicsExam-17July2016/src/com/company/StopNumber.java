package com.company;

import java.util.Scanner;

public class StopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int s = Integer.parseInt(scanner.nextLine());

        if ((n >= 0 && n < m) && (m <= 10000) && (s >= n && s <= m)) {

            for (int i = m; i >= n; i--) {
                if (i % 2 == 0 && i % 3 == 0) {
                    if (i == s) {
                        break;
                    }
                    System.out.printf("%d ", i);
                }
            }

        } else {
            System.out.println("Wrong input!!!");
        }

    }
}
