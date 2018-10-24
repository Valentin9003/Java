package com.company;

import javafx.scene.input.InputMethodTextRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> cityCountry = new HashMap<>();
        HashMap<String, Long> countryTotalPop = new HashMap<>();
        HashMap<String, Long> cityPop = new HashMap<>();

        String input = reader.readLine();

        while (!input.equals("report"))
        {
            String[] inputArr = input.split("\\|") ;
            String country = inputArr[1];
            String city = inputArr[0];
            long population = Long.parseLong(inputArr[2]);

            AddCityCountry(cityCountry, country, city);
            AddCountryAndTotalPopulation(countryTotalPop, country, population);
            AddCityPop(cityPop, city, population);

            input = reader.readLine();
        }

        PrintResult(cityCountry, countryTotalPop, cityPop);

    }

    private static void PrintResult(HashMap<String, String> cityCountry, HashMap<String, Long> countryTotalPop, HashMap<String, Long> cityPop) {
        countryTotalPop.entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue())).forEach(cP -> {
            System.out.println(String.format("%s (total population: %d)", cP.getKey(), cP.getValue()));

            cityPop.entrySet().stream().sorted((x,y) -> y.getValue().compareTo(x.getValue())).forEach(a -> {
                if (cityCountry.get(a.getKey()).equals(cP.getKey())) {
                    System.out.println(String.format("=>%s: %d", a.getKey(), a.getValue()));
                }
            });

        });
    }

    private static void AddCityCountry(HashMap<String, String> cityCountry, String country, String city) {
        if (!cityCountry.containsKey(city)) {
            cityCountry.put(city, country);
        }
    }

    private static void AddCityPop(HashMap<String, Long> cityPop, String city, long population)
    {
        if (!cityPop.containsKey(city)) {
            cityPop.put(city, population);
        } else {
            long value = cityPop.get(city);
            value += population;
            cityPop.replace(city, population);
        }

    }

    private static void AddCountryAndTotalPopulation(HashMap<String, Long> countryTotalPop, String country, long population)
    {
        if (countryTotalPop.containsKey(country))
        {
            long value = countryTotalPop.get(country);
            value += population;
            countryTotalPop.replace(country, value);
        } else {
            countryTotalPop.put(country, population);
        }
    }

}
