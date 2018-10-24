package com.company;

import java.util.Scanner;

public class D2RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        double area = Math.abs(x1-x2)*Math.abs(y1-y2);
        double perimeter = 2*(Math.abs(x1-x2)+Math.abs(y1-y2));

        System.out.printf("Area = %f\n",area);
        System.out.printf("Perimeter = %f",perimeter);
    }
}
