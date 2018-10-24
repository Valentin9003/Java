package p06_rawData;

import p06_rawData.models.Car;
import p06_rawData.models.Cargo;
import p06_rawData.models.Engine;
import p06_rawData.models.Tire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    private static final String FRAGILE_COMMAND = "fragile";
    private static final String FLAMABLE_COMMAND = "flamable";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Car> carsDB = new LinkedList<>();

        int numberOfCars = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfCars; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            String carModel = tokens[0];
            Engine engine = getEngine(tokens);
            Cargo cargo = getCargo(tokens);
            List<Tire> tires = getTires(tokens);

            carsDB.add(new Car(carModel, engine, cargo, tires));
        }

        Predicate<Car> predicate = getPredicate(reader);

        carsDB.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

    private static Predicate<Car> getPredicate(BufferedReader reader) throws IOException {
        Predicate<Car> predicate = null;
        switch (reader.readLine()) {
            case FRAGILE_COMMAND:
                predicate = c -> c.getCargo().getType().equals(FRAGILE_COMMAND)
                        && c.getTires().stream().filter(tire -> tire.getPressure() < 1).collect(Collectors.toList()).size() > 0;
                break;
            case FLAMABLE_COMMAND:
                predicate = c -> c.getCargo().getType().equals(FLAMABLE_COMMAND)
                        && c.getEngine().getPower() > 250;
                break;
        }
        return predicate;
    }

    private static List<Tire> getTires(String[] tokens) {
        List<Tire> tires = new ArrayList<>();
        for (int j = 5; j < tokens.length; j++) {
            double tirePressure = Double.parseDouble(tokens[5]);
            int tireAge = Integer.parseInt(tokens[6]);
            tires.add(new Tire(tirePressure, tireAge));
        }
        return tires;
    }

    private static Cargo getCargo(String[] tokens) {
        int cargoWeight = Integer.parseInt(tokens[3]);
        String cargoType = tokens[4];
        return new Cargo(cargoWeight, cargoType);
    }

    private static Engine getEngine(String[] tokens) {
        int engineSpeed = Integer.parseInt(tokens[1]);
        int enginePower = Integer.parseInt(tokens[2]);
        return new Engine(engineSpeed, enginePower);
    }
}
