package p05_speedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private static final String STOP = "End";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //A Car’s Model is unique - there will never be 2 cars with the same model
        Map<String, Car> cars = new LinkedHashMap<>();

        int carsAmount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < carsAmount; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            fillCarsDB(cars, tokens);
        }

        String line;
        while (!STOP.equalsIgnoreCase(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            executeCommandDrive(cars, tokens);
        }

        cars.values().forEach(System.out::println);
    }

    private static void executeCommandDrive(Map<String, Car> cars, String[] tokens) {
        String carModel = tokens[1];
        double kilometers = Double.parseDouble(tokens[2]);

        try {
            cars.get(carModel).drive(kilometers);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void fillCarsDB(Map<String,Car> cars, String[] tokens) {
        String model = tokens[0];
        double fuelAmount = Double.parseDouble(tokens[1]);
        double fuelCostFor1km = Double.parseDouble(tokens[2]);

        Car car = new Car(model, fuelAmount, fuelCostFor1km);
        cars.putIfAbsent(model, car);
    }
}
