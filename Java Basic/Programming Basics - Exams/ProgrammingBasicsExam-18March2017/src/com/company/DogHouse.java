package com.company;

import java.util.Scanner;

public class DogHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());

        double leftAndRightWall = (a * a/2) * 2;
        double backWall = ((a/2) * (a/2)) + (a/2 * (b - a/2)) / 2;
        double frontWall = backWall - (a/5 * a/5);
        double roof = (a * a/2) *2;

        double greenColor = (leftAndRightWall + backWall + frontWall) / 3;
        double redColor = roof / 5;

        System.out.printf("%.2f",greenColor);
        System.out.println();
        System.out.printf("%.2f",redColor);
    }
}
