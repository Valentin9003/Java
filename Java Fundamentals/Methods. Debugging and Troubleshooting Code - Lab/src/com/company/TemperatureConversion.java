package com.company;

import java.util.Scanner;

public class TemperatureConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double valueInFahreinheit = Double.parseDouble(scanner.nextLine());

        double celsium = FahrenheitToCelsius(valueInFahreinheit);
        System.out.printf("%.2f", celsium);
    }

    private static double FahrenheitToCelsius(double valueInFahreinheit)
    {
        return (valueInFahreinheit - 32) * 5 / 9;
    }
}
