package com.company;

import java.util.Scanner;

public class TheSongOfTheWheels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int controlNumber = Integer.parseInt(scanner.nextLine());
        int password = 0;
        int br = 0;

        for (int i = 1; i <= 9 ; i++) {
            for (int j = 1; j <= 9 ; j++) {
                for (int k = 1; k <= 9 ; k++) {
                    for (int l = 1; l <= 9 ; l++) {

                        if (i * j + k * l == controlNumber) {
                            if (i < j && k > l) {
                                System.out.printf("%d%d%d%d ", i, j, k, l);
                                br++;
                                if (br == 4) {
                                    password = i * 1000 + j * 100 + k *10 + l;
                                }
                            }
                        }

                    }
                }
            }
        }
        if (br < 4) {
            System.out.println();
            System.out.println("No!");
        } else {
            System.out.println();
            System.out.printf("Password: %d", password);
        }

    }
}
