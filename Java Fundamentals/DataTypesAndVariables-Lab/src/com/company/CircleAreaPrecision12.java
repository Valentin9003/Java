package com.company;

import java.util.Scanner;

public class CircleAreaPrecision12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Radius = ");
        double radius = Double.parseDouble(scanner.nextLine());

        double circleArea = Math.PI * radius * radius;

        System.out.printf("%.12f", circleArea);
    }
}
