package com.company;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int lenght = Integer.parseInt(scanner.nextLine());

        double areaCake = width * lenght;
        double sum = 0;

        while (areaCake > 0) {
            String brPieces = scanner.nextLine();
            if (brPieces.equals("STOP")) {
                break;
            }

            int pieces = Integer.parseInt(brPieces);
            sum += pieces;
            if (sum > areaCake) {
                System.out.printf("No more cake left! You need %.0f pieces more.", sum - areaCake);
                return;
            }

//            brPieces = scanner.nextLine();
//            areaCake -= pieces;
        }
        System.out.printf("%.0f pieces are left.", areaCake - sum);
    }
}
