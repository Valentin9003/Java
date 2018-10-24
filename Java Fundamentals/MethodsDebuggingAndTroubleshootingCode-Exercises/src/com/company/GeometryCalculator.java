package com.company;

import java.util.Scanner;

public class GeometryCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String figure = scanner.nextLine().toLowerCase();

        if (figure.equals("triangle")){
            double sideTriangle = Double.parseDouble(scanner.nextLine());
            double heightTriangle = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.2f", TriangleArea(sideTriangle, heightTriangle));
        }
        else if (figure.equals("square")){
            double sideSquare = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.2f", SquareArea(sideSquare));
        }
        else if (figure.equals("rectangle")) {
            double width = Double.parseDouble(scanner.nextLine());
            double heightRectangle = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.2f", RectangleArea(width, heightRectangle));
        }
        else if (figure.equals("circle")) {
            double radiusCircle = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.2f", CircleArea(radiusCircle));
        }
    }

    private static double SquareArea(double sideSquare)
    {
        return Math.pow(sideSquare, 2);
    }

    private static double RectangleArea(double width, double heightRectangle)
    {
        return width * heightRectangle;
    }

    private static double CircleArea(double radiusCircle)
    {
        return Math.PI * Math.pow(radiusCircle, 2);
    }

    private static double TriangleArea(double side, double height)
    {
        return (1  * side * height) / 2;
    }
}
