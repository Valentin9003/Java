package com.company;

import java.util.Scanner;

public class DiferentNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int br = 0;

        for (int i = a; i <= b ; i++) {
            for (int j = a; j <= b ; j++) {
                for (int k = a; k <= b ; k++) {
                    for (int l = a; l <= b ; l++) {
                        for (int m = a; m <= b ; m++) {
                            if (i < j && j < k && k < l && l < m ) {
                                System.out.printf("%d %d %d %d %d %n", i,j,k,l,m);
                                br++;
                            }
                        }
                    }
                }
            }
        }
        if (br == 0) {
            System.out.println("No");
        }
    }
}
