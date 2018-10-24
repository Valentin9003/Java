package p01_vehicles;

import p01_vehicles.models.Car;
import p01_vehicles.models.Truck;
import p01_vehicles.models.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final String DRIVE_COMMAND = "Drive";
    private static final String REFUEL_COMMAND = "Refuel";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Vehicle> vehiclesList = new LinkedList<>();
        fillVehicleDB(reader, vehiclesList);

        int commandsAmount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < commandsAmount; i++) {
            String[] commandTokens = reader.readLine().split("\\s+");
            executeCommand(vehiclesList, commandTokens);
        }

        vehiclesList.forEach(System.out::println);
    }

    private static void fillVehicleDB(BufferedReader reader, List<Vehicle> vehiclesList) throws IOException {
        String[] carTokens = reader.readLine().split("\\s+");
        String[] truckTokens = reader.readLine().split("\\s+");

        vehiclesList.add(new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2])));
        vehiclesList.add(new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2])));
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
                case REFUEL_COMMAND:
                    refuelVehicle(vehiclesList, vehicleType, amount);
                    break;
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void refuelVehicle(List<Vehicle> vehiclesList, String vehicleType, double amount) {
        for (Vehicle vehicle : vehiclesList) {
            if (vehicle.getClass().getSimpleName().equals(vehicleType)) {
                vehicle.refuel(amount);
            }
        }
    }

    private static void driveVehicle(List<Vehicle> vehiclesList, String vehicleType, double amount) {
        for (Vehicle vehicle : vehiclesList) {
            if (vehicle.getClass().getSimpleName().equals(vehicleType)) {
                System.out.println(vehicle.drive(amount));
            }
        }
    }
}
