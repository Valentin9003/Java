package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("###0.00");

        double capacity = Integer.parseInt(scanner.nextLine());
        double brFans = Integer.parseInt(scanner.nextLine());

        double ava = brFans / capacity * 100;

        double brA = 0;
        double brB = 0;
        double brV = 0;
        double brG= 0;

        for (int i = 0; i < brFans ; i++) {
            String sector = scanner.nextLine();

            switch (sector) {
                case "A": brA++; break;
                case "B": brB++; break;
                case "V": brV++; break;
                case "G": brG++; break;
            }
        }
        double a = brA / brFans * 100;
        double b = brB / brFans * 100;
        double v = brV / brFans * 100;
        double g = brG / brFans * 100;

        System.out.println(df.format(a) + "%");
        System.out.println(df.format(b) + "%");
        System.out.println(df.format(v) + "%");
        System.out.println(df.format(g) + "%");
        System.out.println(df.format(ava) + "%");
    }
}
