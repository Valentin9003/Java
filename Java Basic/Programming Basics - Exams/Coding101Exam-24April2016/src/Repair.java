package com.company;

import java.util.Scanner;

public class Repair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n = Double.parseDouble(scanner.nextLine());   //дължината на страна от площадката в интервала [1...100]
        double w = Double.parseDouble(scanner.nextLine());   //широчината на една плочка в интервала [0.1...10.00]
        double L = Double.parseDouble(scanner.nextLine());   //дължината на една плочка в интервала [0.1...10.00]
        double m = Double.parseDouble(scanner.nextLine());   //широчината на пейката в интервала [0...10]
        double o = Double.parseDouble(scanner.nextLine());   //дължината на пейката в интервала [0...10]

        //Да се отпечата на конзолата две числа: броят плочки необходи за ремонта
        // и времето за поставяне, всяко на нов ред. Всяка плочка се поставя за 0.2 минути.

        double area = n * n;
        double areaP = w * L;
        double areaNo = m * o;

        System.out.printf("%.2f",(area - areaNo) / areaP);
        System.out.println();
        System.out.printf("%.2f",((area - areaNo) / areaP) * 0.2);
    }
}
