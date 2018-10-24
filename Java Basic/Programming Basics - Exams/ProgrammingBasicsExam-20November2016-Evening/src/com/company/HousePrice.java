package com.company;

import java.util.Scanner;

public class HousePrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double areaSmallerRoom = Double.parseDouble(scanner.nextLine());
        double areaKitchen = Double.parseDouble(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());

        double areaBath = areaSmallerRoom / 2;
        double secondRoom = areaSmallerRoom + areaSmallerRoom * 0.1;
        double thirdRoom = secondRoom + secondRoom * 0.1;

        double area = areaSmallerRoom + areaKitchen + areaBath + secondRoom + thirdRoom;
        double areaK = area * 0.05;
        area += areaK;

        System.out.printf("%.2f", area * price);
    }
}
