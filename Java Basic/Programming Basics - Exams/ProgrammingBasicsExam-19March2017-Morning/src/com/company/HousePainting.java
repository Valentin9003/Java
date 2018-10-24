package com.company;

import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double fronAndBackWall = (x*x)*2 - 1.2*2;
        double leftRightWalls = (x*y)*2 - (1.5*1.5)*2;
        double roof = (x*y)*2 + 2*(x*h/2);

        double green = (fronAndBackWall + leftRightWalls) / 3.4;
        double red = roof / 4.3;

        System.out.printf("%.2f",green);
        System.out.println();
        System.out.printf("%.2f",red);
    }
}
