package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculateTriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("##########.##########");

        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        double area = GetTriangleArea(width, height);
        System.out.println(df.format(area));
    }

    public static double GetTriangleArea(double width, double height) {
        return width * height / 2;
    }
}
