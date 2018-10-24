package p02_vehiclesExtension;

import p02_vehiclesExtension.models.Bus;
import p02_vehiclesExtension.models.Car;
import p02_vehiclesExtension.models.Truck;
import p02_vehiclesExtension.models.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final String DRIVE_COMMAND = "Drive";
    private static final String DRIVE_EMPTY_COMMAND = "DriveEmpty";
    private static final String REFUEL_COMMAND = "Refuel";
    private static final String CAR = "Car";
    private static final String TRUCK = "Truck";
    private static final String BUS = "Bus";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Vehicle> vehiclesList = new LinkedList<>();
        fillVehicleDB(reader, vehiclesList);

        int commandsAmount = Integer.parseInt(reader.readLine());
        while (commandsAmount-- > 0) {
            String[] commandTokens = reader.readLine().split("\\s+");
            executeCommand(vehiclesList, commandTokens);
        }

        vehiclesList.forEach(System.out::println);
    }

    private static void fillVehicleDB(BufferedReader reader, List<Vehicle> vehiclesList) throws IOException {
        for (int i = 0; i < 3; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            double fuelQuantity = Double.parseDouble(tokens[1]);
            double litersPerKm = Double.parseDouble(tokens[2]);
            double tankCapacity = Double.parseDouble(tokens[3]);

            switch (tokens[0]) {
                case CAR:
                    vehiclesList.add(new Car(fuelQuantity, litersPerKm, tankCapacity));
                    break;
                case TRUCK:
                    vehiclesList.add(new Truck(fuelQuantity, litersPerKm, tankCapacity));
                    break;
                case BUS:
                    vehiclesList.add(new Bus(fuelQuantity, litersPerKm, tankCapacity));
                    break;
            }
        }
    }

    private static void executeCommand(List<Vehicle> vehiclesList, String[] commandTokens) {
        String command = commandTokens[0];
        String vehicleType = commandTokens[1];
        double amount = Double.parseDouble(commandTokens[2]);

        try {
            switch (command) {
                case DRIVE_COMMAND:
                    driveVehicle(vehiclesList, vehicleType, amount);
                    break;
                case DRIVE_EMPTY_COMMAND:
                    driveEmptyVehicle(vehiclesList, amount);
                    break;
                case REFUEL_COMMAND:
                    refuelVehicle(vehiclesList, vehicleType, amount);
                    break;
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void refuelVehicle(List<Vehicle> vehiclesList, String vehicleType, double amount) {
        vehiclesList.stream()
                .filter(vehicle -> vehicle.getClass().getSimpleName().equals(vehicleType))
                .forEach(vehicle -> vehicle.refuel(amount));
    }

    private static void driveEmptyVehicle(List<Vehicle> vehiclesList, double amount) {
        vehiclesList.stream()
                .filter(vehicle -> vehicle.getClass().getSimpleName().equals(BUS))
                .forEach(vehicle -> {
                    System.out.println(vehicle.drive(amount, true));
                });
    }

    private static void driveVehicle(List<Vehicle> vehiclesList, String vehicleType, double amount) {
        vehiclesList.stream()
                .filter(vehicle -> vehicle.getClass().getSimpleName().equals(vehicleType))
                .forEach(vehicle -> {
                    System.out.println(vehicle.drive(amount));
                });
    }
}
