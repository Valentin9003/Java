package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class SupermarketDatabase {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, List<Double>> marketNPQ = new LinkedHashMap<>();

        String[] input = reader.readLine().split(" ");
        while (!input[0].equals("stocked"))
        {
            AddMarketNPQ(input, marketNPQ);
            input = reader.readLine().split(" ");
        }

        PrintMarketNPQandTotal(marketNPQ);
    }

    private static void PrintMarketNPQandTotal(LinkedHashMap<String, List<Double>> marketNPQ)
    {
        double total = 0;
        for (String stock : marketNPQ.keySet()) {
            double price = marketNPQ.get(stock).get(0);
            double quantity = marketNPQ.get(stock).get(1);
            double sum = price * quantity;
            total += sum;
            System.out.println(String.format("%s: $%.2f * %.0f = $%.2f", stock, price, quantity, sum));
        }
        for (int i = 0; i < 30; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println(String.format("Grand Total: $%.2f", total));
    }

    private static void AddMarketNPQ(String[] input, LinkedHashMap<String, List<Double>> marketNPQ)
    {
        String stock = input[0];
        double price = Double.parseDouble(input[1]);
        double quantity = Double.parseDouble(input[2]);

        if (!marketNPQ.containsKey(stock)) {
            marketNPQ.put(stock, new ArrayList<>());
            marketNPQ.get(stock).add(price);
            marketNPQ.get(stock).add(quantity);
        } else {
            double value = marketNPQ.get(stock).get(1);
            value += quantity;
            marketNPQ.replace(stock, new ArrayList<>());
            marketNPQ.get(stock).clear();
            marketNPQ.get(stock).add(price);
            marketNPQ.get(stock).add(value);
        }
    }
}
