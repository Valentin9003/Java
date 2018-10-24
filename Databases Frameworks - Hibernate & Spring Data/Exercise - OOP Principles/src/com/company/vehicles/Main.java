package com.company.vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Vehicles car = createCar(reader);
        Vehicles truck = createTruck(reader);
        readCommands(reader, car, truck);
        printCarTruckLeftFuel(car, truck);
    }

    private static void printCarTruckLeftFuel(Vehicles car, Vehicles truck) {
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }

    private static void readCommands(BufferedReader reader, Vehicles car, Vehicles truck) throws IOException {
        int countOfCommands = Integer.parseInt(reader.readLine());
        for (int i = 0; i < countOfCommands; i++) {
            String[] commandArr = reader.readLine().split("\\s+");
            if (commandArr.length != 3) {
                continue;
            }
            executeCommand(car, truck, commandArr);
        }
    }

    private static Vehicles createCar(BufferedReader reader) throws IOException {
        String[] carTokens = reader.readLine().split("\\s+");
        double fuelQuantity = Double.parseDouble(carTokens[1]);
        double consumption = Double.parseDouble(carTokens[2]);

        return new Car(fuelQuantity, consumption);
    }

    private static Vehicles createTruck(BufferedReader reader) throws IOException {
        String[] truckTokens = reader.readLine().split("\\s+");
        double fuelQuantity = Double.parseDouble(truckTokens[1]);
        double consumption = Double.parseDouble(truckTokens[2]);

        return new Truck(fuelQuantity, consumption);
    }

    private static void executeCommand(Vehicles car, Vehicles truck, String[] commandArr) {
        String command = commandArr[0];
        String vehicle = commandArr[1];
        double token = Double.parseDouble(commandArr[2]);

        CommandCenter cc = new CommandCenter();
        switch (vehicle) {
            case "Car":
                cc.executeCommand(car, command, token);
                break;
            case "Truck":
                cc.executeCommand(truck, command, token);
                break;
        }
    }
}
