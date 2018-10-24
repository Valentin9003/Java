package com.company.beerCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BeerCounter beerCounter = new BeerCounter();
        try {
            String inputLine = reader.readLine();

            while (!inputLine.equals("End")) {
                long[] tokens = Arrays.stream(inputLine.split("\\s+")).mapToLong(Long::parseLong).toArray();
                long boughtBeers = tokens[0];
                long drankBeers = tokens[1];

                beerCounter.buyBeer(boughtBeers);
                beerCounter.drinkBeer(drankBeers);

                inputLine = reader.readLine();
            }
        } catch (Exception blocking) {
        } finally {
            System.out.println(beerCounter.toString());
        }
    }
}
