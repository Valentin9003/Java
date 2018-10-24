package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#0.00");

        int brStudents =Integer.parseInt(scanner.nextLine());

        double top = 0;
        double veryGood = 0;
        double good = 0;
        double fail = 0;
        double avarage = 0;

        for (int i = 0; i < brStudents; i++) {
            double result = Double.parseDouble(scanner.nextLine());
            avarage += result;
            if (result >= 5.00) {
                top++;
            } else if (result >= 4.00 && result <= 4.99) {
                veryGood++;
            } else if (result >= 3.00 && result <= 3.99) {
                good++;
            } else if (result >= 2.00 && result <= 2.99) {
                fail++;
            }
        }
        double ave = avarage / brStudents;
        double topS = top / brStudents * 100;
        double vgS = veryGood / brStudents * 100;
        double gS = good / brStudents * 100;
        double fS = fail / brStudents * 100;

        System.out.println("Top students: " + df.format(topS) + "%");
        System.out.println("Between 4.00 and 4.99: " + df.format(vgS) + "%");
        System.out.println("Between 3.00 and 3.99: " + df.format(gS) + "%");
        System.out.println("Fail: " + df.format(fS) + "%");
        System.out.println("Average: " + df.format(ave));
    }
}
