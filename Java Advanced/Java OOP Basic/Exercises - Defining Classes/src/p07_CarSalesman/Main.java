package p07_CarSalesman;

import p07_CarSalesman.models.Car;
import p07_CarSalesman.models.Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Engine> enginesDB = new HashMap<>();
        List<Car> carsDB = new LinkedList<>();

        fillEnginesDatabase(reader, enginesDB);
        fillCarsDatabase(reader, enginesDB, carsDB);

        carsDB.forEach(System.out::print);
    }

    private static void fillCarsDatabase(BufferedReader reader, Map<String, Engine> enginesDB, List<Car> carsDB) throws IOException {
        int numberOfCars = Integer.parseInt(reader.readLine());
        while (numberOfCars-- > 0) {
            String[] carTokens = reader.readLine().split("\\s+");
            Car car = produceCar(enginesDB, carTokens);
            carsDB.add(car);
        }
    }

    private static void fillEnginesDatabase(BufferedReader reader, Map<String, Engine> enginesDB) throws IOException {
        int linesOfEngines = Integer.parseInt(reader.readLine());
        while (linesOfEngines-- > 0) {
            String[] engineTokens = reader.readLine().split("\\s+");
            Engine engine = produceEngine(engineTokens);
            enginesDB.putIfAbsent(engine.getModel(), engine);
        }
    }

    private static Car produceCar(Map<String, Engine> enginesDB, String[] carTokens) {
        String carModel = carTokens[0];
        String engineModel = carTokens[1];
        int weight;
        String color;
        Car car = null;
        Engine engine = null;

        switch (carTokens.length) {
            case 2:
                engine = enginesDB.get(engineModel);
                car = new Car(carModel, engine);
                break;
            case 3:
                try {
                    weight = Integer.parseInt(carTokens[2]);
                    engine = enginesDB.get(engineModel);
                    car = new Car(carModel, engine, weight);
                } catch (NumberFormatException nfe) {
                    color = carTokens[2];
                    engine = enginesDB.get(engineModel);
                    car = new Car(carModel, engine, color);
                }
                break;
            case 4:
                weight = Integer.parseInt(carTokens[2]);
                color = carTokens[3];
                engine = enginesDB.get(engineModel);
                car = new Car(carModel, engine, weight, color);
                break;
        }
        return car;
    }

    private static Engine produceEngine(String[] engineTokens) {
        String model = engineTokens[0];
        int power = Integer.parseInt(engineTokens[1]);
        int displacement;
        String efficiency;
        Engine engine = null;

        switch (engineTokens.length) {
            case 2:
                engine = new Engine(model, power);
                break;
            case 3:
                try {
                    displacement = Integer.parseInt(engineTokens[2]);
                    engine = new Engine(model, power, displacement);
                } catch (NumberFormatException nfe) {
                    efficiency = engineTokens[2];
                    engine = new Engine(model, power, efficiency);
                }
                break;
            case 4:
                displacement = Integer.parseInt(engineTokens[2]);
                efficiency = engineTokens[3];
                engine = new Engine(model, power, displacement, efficiency);
                break;
        }
        return engine;
    }
}
