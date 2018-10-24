package com.company;

import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String figure = scanner.nextLine();
        double a = Double.parseDouble(scanner.nextLine());
        double area = 0;

        if (figure.equalsIgnoreCase("square")) {
            area = a * a;
            System.out.println(area);
        } else if (figure.equalsIgnoreCase("rectangle")) {
            double b = Double.parseDouble(scanner.nextLine());
            area = a* b;
            System.out.println(area);
        } else if (figure.equalsIgnoreCase("circle")) {
            area = Math.PI * a * a;
            System.out.println(area);
        } else if (figure.equalsIgnoreCase("triangle")) {
            double h = Double.parseDouble(scanner.nextLine());
            area = (a * h) / 2;
            System.out.println(area);
        }
    }
}
