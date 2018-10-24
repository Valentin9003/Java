package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("##.##");

        int n = Integer.parseInt(scanner.nextLine());

        double sumOdd = 0;
        double sumEven = 0;
        double maxOdd = -555555555;
        double maxEven = -555555555;
        double minOdd = 555555555;
        double minEven = 555555555;

        for (int i = 1; i <= n; i++) {
            double number = Double.parseDouble(scanner.nextLine());;

            if (i % 2 == 0) {
                sumEven += number;
                if (number > maxEven) {
                    maxEven = number;
                } if (number < minEven) {
                    minEven = number;
                }
            } else {
                sumOdd += number;
                if (number > maxOdd) {
                    maxOdd = number;
                } if (number < minOdd) {
                    minOdd = number;
                }
            }
        }
        System.out.println("OddSum=" + df.format(sumOdd) + ",");
        if (minOdd != 555555555) {
            System.out.println("OddMin=" + df.format(minOdd) + ",");
        } else {System.out.println("OddMin=No,");}
        if (maxOdd != -555555555 ) {
            System.out.println("OddMax=" + df.format(maxOdd) + ",");
        } else { System.out.println("OddMax=No,"); }
        System.out.println("EvenSum=" + df.format(sumEven) + ",");
        if (minEven != 555555555) {
            System.out.println("EvenMin=" + df.format(minEven) + ",");
        } else { System.out.println("EvenMin=No,"); }
        if (maxEven != -555555555 ) {
            System.out.println("EvenMax=" + df.format(maxEven));
        } else { System.out.println("EvenMax=No"); }
    }
}
