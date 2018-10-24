package com.company;

import java.util.Scanner;

public class CatchTheThief {
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

        System.out.println(result);
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
