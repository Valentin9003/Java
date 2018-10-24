package com.company;

import java.util.Scanner;

public class MaxCombination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberStart = Integer.parseInt(scanner.nextLine());
        int numberStop = Integer.parseInt(scanner.nextLine());
        int maxComb = Integer.parseInt(scanner.nextLine());

        int br = 0;
        for (int i = numberStart; i <= numberStop ; i++) {
            for (int j = numberStart; j <= numberStop ; j++) {
                br++;
                if (br <= maxComb) {
                    System.out.printf("<%d-%d>", i,j);
                }
            }
        }
    }
}
