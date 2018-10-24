package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#############.###########");

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        double dist1 = CalcDistance(x1, y1);
        double dist2 = CalcDistance(x2, y2);

        if (dist1 >= dist2)
        {
            System.out.printf("(%s, %s)", df.format(x2), df.format(y2));
        }
        else
        {
            System.out.printf("(%s, %s)", df.format(x1), df.format(y1));
        }
    }

    public static double CalcDistance(double x, double y)
    {
        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return distance;
    }
}
