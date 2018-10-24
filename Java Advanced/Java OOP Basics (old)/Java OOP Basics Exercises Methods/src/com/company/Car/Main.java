package com.company.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputTokens = reader.readLine().split("\\s+");
        String[] travelDistance = reader.readLine().split("\\s+");

        double speed = Double.parseDouble(inputTokens[0]);
        double fuel = Double.parseDouble(inputTokens[1]);
        double fuelEconomy = Double.parseDouble(inputTokens[2]);
        double travelDis = Double.parseDouble(travelDistance[1]);

        Car car = new Car(speed, fuel, fuelEconomy);
        car.travel(travelDis);

        String command = reader.readLine();
        while (!command.equals("END")) {

            executeCommand(command, car);

            command = reader.readLine();
        }
    }

    private static void executeCommand(String command, Car car) {

        switch (command) {
            case "Distance":
                System.out.println(String.format("Total distance: %.1f kilometers", car.getDistanceTravelled()));
                break;

            case "Time":
                double time = car.getTimeTravelled() * 60;
                int h = (int)time / 60;
                int min = (int)time % 60;
                System.out.println(String.format("Total time: %d hours and %d minutes", h, min));
                break;

            case "Fuel":
                System.out.println(String.format("Fuel left: %.1f liters", car.getFuel()));
                break;
        }
    }
}
