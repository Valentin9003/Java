package com.company;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberInputs = Integer.parseInt(scanner.nextLine());

        double volumeOfTheKeg = 0.0;
        String biggestKegIs = "";
        for (int i = 0; i < numberInputs ; i++)
        {
            String modelOfTheBeerKeg = scanner.nextLine();
            double radiusOfTheKeg = Double.parseDouble(scanner.nextLine());
            int heightOnTheKeg = Integer.parseInt(scanner.nextLine());

            double volumeOfInputKegIs = CalculateVolumeOfTheKeg(radiusOfTheKeg, heightOnTheKeg);

            if (volumeOfInputKegIs > volumeOfTheKeg)
            {
                volumeOfTheKeg = volumeOfInputKegIs;
                biggestKegIs = modelOfTheBeerKeg;
            }
        }

        System.out.println(biggestKegIs);
    }

    private static double CalculateVolumeOfTheKeg(double radiusOfTheKeg, int heightOnTheKeg)
    {
        return Math.PI * Math.pow(radiusOfTheKeg, 2) * (double) heightOnTheKeg;
    }
}
