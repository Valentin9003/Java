package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class inPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat format = new DecimalFormat("0.##");

        int v = Integer.parseInt(scanner.nextLine());          // obem na baseina v litri [1...10000]
        int p1 = Integer.parseInt(scanner.nextLine());         // debit na 1ta tryba za 1h [1...5000]
        int p2 = Integer.parseInt(scanner.nextLine());         // debit na 2ta tryba za 1h [1...5000]
        double h = Double.parseDouble(scanner.nextLine());     // Chasove koito rabotnikyt otcystva - chislo s

        //         plavashta zapetaq v intervala [1.0...24.00]

        double water = p1 * h + p2 * h;

        if (water <= v) {
            System.out.println("The pool is " + (int) (water/v*100) + "% full. Pipe 1: "
                    + (int)(p1 * h / water * 100) + "%. Pipe 2: "
                    + (int)(p2 * h / water * 100) + "%." );
        } else {
            double more = water - v;
            System.out.printf("For " + format.format(h) + " hours the pool overflows with %.1f liters.", more);
        }

    }
}
