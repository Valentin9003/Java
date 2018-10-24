package com.company;

import java.util.Scanner;

public class WeatherForecast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            long number = Long.parseLong(scanner.nextLine());
            System.out.println(PredictTheWeather(number));
        } catch (NumberFormatException e) {
            System.out.println("Rainy");
        }
    }

    private static String PredictTheWeather(double number)
    {
        String weather = "";

        if (number >= Byte.MIN_VALUE && number <= Byte.MAX_VALUE) {
            weather = "Sunny";
        }
        else if (number >= Integer.MIN_VALUE && number <= Integer.MAX_VALUE) {
            weather = "Cloudy";
        }
        else if (number >= Long.MIN_VALUE && number <= Long.MAX_VALUE) {
            weather = "Windy";
        }

        return weather;
    }
}
