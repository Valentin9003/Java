package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Megapixels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#####################0.0");

        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.0fx%.0f => ",width, height);
        System.out.print(df.format(CalculateMegapixels(width, height)) + "MP");
    }

    public static double CalculateMegapixels (double w, double h)
    {
        double sum = (w * h) / 1000000;
        return sum;

    }
}
