package com.company;

import java.util.Scanner;

public class Battles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstPlayer = Integer.parseInt(scanner.nextLine());
        int secondPlayer = Integer.parseInt(scanner.nextLine());
        int battles = Integer.parseInt(scanner.nextLine());

        int br = 0;

        for (int j = 1; j <= firstPlayer; j++) {
            for (int k = 1; k <= secondPlayer; k++) {
                br++;
                if (br <= battles) {
                    System.out.printf("(%d <-> %d) ", j, k);
                }
            }
        }
    }
}
