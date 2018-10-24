package com.company.Problem4BeerCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeerCounterMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] pair = reader.readLine().split("\\s+");
        while (!pair[0].equals("End")) {
            int boughtBeers = Integer.valueOf(pair[0]);
            int drankBeers = Integer.valueOf(pair[1]);

            BeerCounter beerCounter = new BeerCounter(boughtBeers, drankBeers);

            pair = reader.readLine().split("\\s+");
        }

        System.out.println(BeerCounter.beerInStock + " " + BeerCounter.beersDrankCount);
    }
}
