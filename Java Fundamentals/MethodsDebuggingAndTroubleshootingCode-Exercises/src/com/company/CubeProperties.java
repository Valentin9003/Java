package com.company;

import java.util.Scanner;

public class CubeProperties {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double side = Double.parseDouble(scanner.nextLine());
        String function = scanner.nextLine();

        switch (function) {
            case "face":
                System.out.printf("%.2f", CubeFaceDiagonal(side));
                break;
            case "space":
                System.out.printf("%.2f", CubeSpaceDiagonal(side));
                break;
            case "volume":
                System.out.printf("%.2f", CubeVolume(side));
                break;
            case "area":
                System.out.printf("%.2f", CubeSurfaceArea(side));
                break;
        }
    }

    private static double CubeSurfaceArea(double side)
    {
        return 6 * Math.pow(side, 2);
    }

    private static double CubeVolume(double side)
    {
        return Math.pow(side, 3);
    }

    private static double CubeSpaceDiagonal(double side)
    {
        return Math.sqrt(3 * Math.pow(side, 2));
    }

    private static double CubeFaceDiagonal(double side)
    {
        return Math.sqrt(2 * Math.pow(side, 2));
    }

}
