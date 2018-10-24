package com.company.Problem3TemperatureConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TemperatureConverterMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");
        while (!tokens[0].equals("End")) {

            Temperature temperature = null;
            executeCommand(temperature, tokens);

            tokens = reader.readLine().split("\\s+");
        }
    }

    private static void executeCommand(Temperature temperature, String[] tokens) {
        int temp = Integer.valueOf(tokens[0]);
        String type = tokens[1];

        switch (type) {
            case "Celsius":
                temperature = new Celsius(temp);
                break;
            case "Fahrenheit":
                temperature = new Fahrenheit(temp);
                break;
        }

        temperature.convert();
    }
}
