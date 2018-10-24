package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TouristInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("###########################0.##############################");

        String imperialUnit = scanner.nextLine().toLowerCase();
        double value = Double.parseDouble(scanner.nextLine());

        System.out.printf("%s %s = %.2f %s"
                ,df.format(value)
                ,imperialUnit
                ,ConvertImperialUnitsToMetricUnits(value, imperialUnit)
                ,ResultIn(imperialUnit));

    }

    private static String ResultIn(String imperialUnit)
    {
        String resultIn = "";

        switch (imperialUnit) {
            case "miles":
                resultIn = "kilometers";
                break;
            case "inches":
                resultIn = "centimeters";
                break;
            case "feet":
                resultIn = "centimeters";
                break;
            case "yards":
                resultIn = "meters";
                break;
            case "gallons":
                resultIn = "liters";
                break;
        }
        return resultIn;
    }

    private static double ConvertImperialUnitsToMetricUnits(double value, String imperialUnit)
    {
        double multiplyBy = ValueForMultiply(imperialUnit);

        return (value * multiplyBy);
    }

    private static double ValueForMultiply(String imperialUnit)
    {
        double value = 0.0;

        switch (imperialUnit) {
            case "miles":
                value = 1.6;
                break;
            case "inches":
                value = 2.54;
                break;
            case "feet":
                value = 30;
                break;
            case "yards":
                value = 0.91;
                break;
            case "gallons":
                value = 3.8;
                break;
        }
        return value;
    }
}
