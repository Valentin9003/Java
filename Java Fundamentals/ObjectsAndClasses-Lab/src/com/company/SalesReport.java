package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class SalesReport {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        TreeMap<String, Double> myMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            ReadSaleInput(reader.readLine(), myMap);
        }

        PrintMap(myMap);

    }

    private static void PrintMap(TreeMap<String, Double> myMap)
    {
        for (String town : myMap.keySet()) {
            System.out.println(String.format("%s -> %.2f", town, myMap.get(town)));
        }
    }

    private static void ReadSaleInput(String input, TreeMap<String, Double> myMap)
    {
        String[] inputArr = input.split(" ");
        Sale newSale = new Sale();
        newSale.Town = inputArr[0];
        newSale.Product = inputArr[1];
        newSale.Price = Double.parseDouble(inputArr[2]);
        newSale.Quantity = Double.parseDouble(inputArr[3]);

        if (!myMap.containsKey(newSale.Town)) {
            myMap.put(newSale.Town, newSale.Sum());
        } else {
            double sum = myMap.get(newSale.Town);
            sum += newSale.Sum();
            myMap.replace(newSale.Town, sum);
        }
    }

}

class Sale {
     String Town;
    String Product;
    double Price;
    double Quantity;

    public double Sum()
    {
        return Price * Quantity;
    }

}
