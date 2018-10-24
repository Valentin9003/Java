package com.company;

import java.util.Scanner;

public class SentenceTheThief {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String idType = scanner.nextLine().toLowerCase();
        long countOfIDs = Long.parseLong(scanner.nextLine());

        long result = Long.MIN_VALUE;
        for (int i = 0; i < countOfIDs; i++)
        {
            long inputID = Long.parseLong(scanner.nextLine());

            if (inputID <= FoundTiefID(idType) && inputID > result)
            {
                result = inputID;
            }
        }

        long printResult = (long)CalculateSintenceYears(idType, result);
        if (printResult == 1) {
            System.out.printf("Prisoner with id %d is sentenced to %d year", result, printResult);
        } else {
            System.out.printf("Prisoner with id %d is sentenced to %d years", result, printResult);
        }
    }

    private static double CalculateSintenceYears(String idType, long result)
    {
        double years = 0;

        if (result < 0) {
            switch (idType) {
                case "sbyte":
                    double index = Byte.MIN_VALUE;
                    years += result / index;
                    break;
                case "int":
                    index = Byte.MIN_VALUE;
                    years += result / index;
                    break;
                case "long":
                    index = Byte.MIN_VALUE;
                    years += result / index;
                    break;
            }
        } else {
            switch (idType) {
                case "sbyte":
                    double index = Byte.MAX_VALUE;
                    years += result / index;
                    break;
                case "int":
                    index = Byte.MAX_VALUE;
                    years += result / index;
                    break;
                case "long":
                    index = Byte.MAX_VALUE;
                    years += result / index;
                    break;
            }
        }

        return Math.ceil(years);
    }

    private static long FoundTiefID(String idType)
    {
        long idOfTheTief = 0;

        switch (idType) {
            case "sbyte":
                idOfTheTief = Byte.MAX_VALUE;
                break;
            case "int":
                idOfTheTief = Integer.MAX_VALUE;
                break;
            case "long":
                idOfTheTief = Long.MAX_VALUE;
                break;
        }
        return idOfTheTief;
    }
}