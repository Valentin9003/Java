package com.company;

import java.util.Scanner;

public class RefactorVolumeOfPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double lenght = 0;
        double width = 0;
        double height = 0;

        System.out.print("Length: ");
        lenght = Double.parseDouble(scanner.nextLine());

        System.out.print("Width: ");
        width = Double.parseDouble(scanner.nextLine());

        System.out.print("Height: ");
        height = Double.parseDouble(scanner.nextLine());

        double volumeOfPiramid = (lenght * width * height) / 3;

        System.out.printf("Pyramid Volume: %.2f", volumeOfPiramid);
    }
}
