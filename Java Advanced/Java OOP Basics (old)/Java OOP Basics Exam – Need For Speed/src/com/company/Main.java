package com.company;

import com.company.controller.CarManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CarManager carManager = new CarManager();

        String inputLine = reader.readLine();
        while (!inputLine.equals("Cops Are Here")) {
            try {
                processingCommands(inputLine, carManager);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            inputLine = reader.readLine();
        }
    }

    private static void processingCommands(String inputLine, CarManager carManager) {
        String command = inputLine.split(" ")[0];
        switch (command) {
            case "register":
                executeCommandRegister(inputLine, carManager);
                break;
            case "check":
                executeCommandCheck(inputLine, carManager);
                break;
            case "open":
                executeCommandOpen(inputLine, carManager);
                break;
            case "participate":
                executeCommandParticipate(inputLine, carManager);
                break;
            case "start":
                executeCommandStart(inputLine, carManager);
                break;
            case "park":
                executeCommandPark(inputLine, carManager);
                break;
            case "unpark":
                executeCommandUnpark(inputLine, carManager);
                break;
            case "tune":
                executeCommandTune(inputLine, carManager);
                break;
        }
    }

    private static void executeCommandTune(String inputLine, CarManager carManager) {
        String[] tokens = inputLine.split(" ");
        int tuneIndex = Integer.valueOf(tokens[1]);
        String tuneAddOn = tokens[2];

        carManager.tune(tuneIndex, tuneAddOn);
    }

    private static void executeCommandUnpark(String inputLine, CarManager carManager) {
        String[] tokens = inputLine.split(" ");
        int carId = Integer.valueOf(tokens[1]);

        carManager.unpark(carId);
    }

    private static void executeCommandPark(String inputLine, CarManager carManager) {
        String[] tokens = inputLine.split(" ");
        int carId = Integer.valueOf(tokens[1]);

        carManager.park(carId);
    }

    private static void executeCommandStart(String inputLine, CarManager carManager) {
        String[] tokens = inputLine.split(" ");
        int raceId = Integer.valueOf(tokens[1]);

        System.out.println(carManager.start(raceId));
    }

    private static void executeCommandParticipate(String inputLine, CarManager carManager) {
        String[] tokens = inputLine.split(" ");
        int carId = Integer.valueOf(tokens[1]);
        int raceId = Integer.valueOf(tokens[2]);

        carManager.participate(carId, raceId);
    }

    private static void executeCommandOpen(String inputLine, CarManager carManager) {
        String[] tokens = inputLine.split(" ");
        int id = Integer.valueOf(tokens[1]);
        String type = tokens[2];
        int length = Integer.valueOf(tokens[3]);
        String route = tokens[4];
        int prizePool = Integer.valueOf(tokens[5]);

        carManager.open(id, type, length, route, prizePool);
    }

    private static void executeCommandCheck(String inputLine, CarManager carManager) {
        String[] tokens = inputLine.split(" ");
        int id = Integer.valueOf(tokens[1]);

        System.out.println(carManager.check(id));
    }

    private static void executeCommandRegister(String inputLine, CarManager carManager) {
        String[] tokens = inputLine.split(" ");
        int id = Integer.valueOf(tokens[1]);
        String type = tokens[2];
        String brand = tokens[3];
        String model = tokens[4];
        int yearOfProduction = Integer.valueOf(tokens[5]);
        int horsepower = Integer.valueOf(tokens[6]);
        int acceleration = Integer.valueOf(tokens[7]);
        int suspension = Integer.valueOf(tokens[8]);
        int durability = Integer.valueOf(tokens[9]);

        carManager.register(id,
                type,
                brand,
                model,
                yearOfProduction,
                horsepower,
                acceleration,
                suspension,
                durability);
    }
}
