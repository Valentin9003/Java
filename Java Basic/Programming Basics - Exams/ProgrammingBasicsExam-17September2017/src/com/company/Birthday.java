package com.company;

import java.util.Scanner;

public class Birthday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lenght = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double porcent = Double.parseDouble(scanner.nextLine());

        double v = lenght * width * height;
        double allL = v * 0.001;
        porcent *= 0.01;
        double realLitters = allL * (1 - porcent);

        System.out.printf("%.3f", realLitters);
    }
}
