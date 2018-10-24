package com.company;

import java.util.Scanner;

public class SquareOfStars {

    Scanner scanner = new Scanner(System.in);

    int n = Integer.parseInt(scanner.nextLine());

        for (int r=0; r < n; r++) {
           for (int k=0; k < n; k++) {

                if (k == 0 || r == 0) {
                    System.out.print("*");
                }
                else if (k==n-1 || r==n-1) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }

}

