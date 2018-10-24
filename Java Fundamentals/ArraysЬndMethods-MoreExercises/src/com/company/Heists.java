package com.company;

import sun.text.resources.cldr.ia.FormatData_ia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heists {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long[] jewelsAndGoldPrice = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::valueOf).toArray();

        long totalEarnings = 0;
        long expensesTotal = 0;

        List<String> myList = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s")));
        String exit = myList.get(0) + " " + myList.get(1);
        while (!exit.equals("Jail Time"))
        {
            long expenses = Long.parseLong(myList.get(1));
            expensesTotal += expenses;
            totalEarnings += CalculateGoldAndJewelFromTheHeists(myList, jewelsAndGoldPrice);

            myList = Arrays.asList(reader.readLine().split("\\s"));
            exit = myList.get(0) + " " + myList.get(1);
        }

        long win = totalEarnings - expensesTotal;
        if (totalEarnings >= expensesTotal) {
            System.out.printf("Heists will continue. Total earnings: %d.", win);
        } else {
            System.out.printf("Have to find another job. Lost: %d.", (expensesTotal - totalEarnings));
        }

    }

    private static long CalculateGoldAndJewelFromTheHeists(List<String> myList, long[] jewelsAndGoldPrice)
    {
        long price = 0;
        String wordCode = myList.get(0);
        for (int i = 0; i < wordCode.length(); i++) {
            if (wordCode.charAt(i) == '%') {
                price += jewelsAndGoldPrice[0];       //Jewel  price - first element in jewelsAndGoldPrice Array
            }
            else if (wordCode.charAt(i) == '$') {
                price += jewelsAndGoldPrice[1];       //Gold  price - second element in jewelsAndGoldPrice Array
            }
        }
        return price;
    }
}
