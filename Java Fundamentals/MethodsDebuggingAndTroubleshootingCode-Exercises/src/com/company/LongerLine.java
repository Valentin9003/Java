package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class LongerLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = 0.0;
        double y1 = 0.0;
        double x2 = 0.0;
        double y2 = 0.0;

        double maxLineLenght = Double.MIN_VALUE;
        double maxx1 = 0.0;
        double maxy1 = 0.0;
        double maxx2 = 0.0;
        double maxy2 = 0.0;

        for (int i = 0; i < 2 ; i++) {
            x1 = Double.parseDouble(scanner.nextLine());
            y1 = Double.parseDouble(scanner.nextLine());
            x2 = Double.parseDouble(scanner.nextLine());
            y2 = Double.parseDouble(scanner.nextLine());

            double line = FindLine(x1, x2, y1, y2);
            if (line > maxLineLenght) {
                maxLineLenght = line;
                maxx1 = x1;
                maxx2 = x2;
                maxy1 = y1;
                maxy2 = y2;
            }
        }
        PrintResult(maxx1, maxx2, maxy1, maxy2);
    }

    private static void PrintResult(double x1, double x2, double y1, double y2)
    {
        DecimalFormat df = new DecimalFormat("##########################0.########################");

        double distanceOne = Math.sqrt(x1 * x1 + y1 * y1);
        double distanceTwo = Math.sqrt(x2 * x2 + y2 * y2);

        if (distanceTwo < distanceOne) {
            System.out.printf("(%s, %s)(%s, %s)%n", df.format(x2), df.format(y2), df.format(x1), df.format(y1));
        } else {
            System.out.printf("(%s, %s)(%s, %s)%n", df.format(x1), df.format(y1), df.format(x2), df.format(y2));
        }
    }

    private static double FindLine(double x1, double x2, double y1, double y2)
    {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}
