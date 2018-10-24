package com.company.controller;

import com.company.exceptions.*;
import com.company.interfaces.ICarManager;
import com.company.models.carsModels.Car;
import com.company.models.carsModels.PerformanceCar;
import com.company.models.carsModels.ShowCar;
import com.company.models.garage.Garage;
import com.company.models.raceModels.CasualRace;
import com.company.models.raceModels.DragRace;
import com.company.models.raceModels.DriftRace;
import com.company.models.raceModels.Race;

import java.util.HashMap;

public class CarManager implements ICarManager {

    private HashMap<Integer, Car> idCarsMap;
    private HashMap<Integer, Race> idRacesMap;
    private Garage garage;

    public CarManager() {
        this.idCarsMap = new HashMap<>();
        this.idRacesMap = new HashMap<>();
        this.garage = new Garage();
    }

    @Override
    public void register(int id,
                         String type,
                         String brand,
                         String model,
                         int yearOfProduction,
                         int horsepower,
                         int acceleration,
                         int suspension,
                         int durability) {

        Car car = null;
        switch (type) {
            case "Performance":
                car = new PerformanceCar(brand,
                        model,
                        yearOfProduction,
                        horsepower,
                        acceleration,
                        suspension,
                        durability);
                break;
            case "Show":
                car = new ShowCar(brand,
                        model,
                        yearOfProduction,
                        horsepower,
                        acceleration,
                        suspension,
                        durability);
                break;
        }
        addCarToDatabase(id, car);
    }

    @Override
    public String check(int id) {
        if (!idCarsMap.containsKey(id) && !garage.getParkedCars().containsKey(id)) {
            throw new InvalidCheckIdException();
        }

        if (idCarsMap.containsKey(id)) {
            return idCarsMap.get(id).toString();
        } else {
            return garage.getParkedCars().get(id).toString();
        }
    }

    @Override
    public void open(int id, String type, int length, String route, int prizePool) {
        Race race = null;
        switch (type) {
            case "Casual":
                race = new CasualRace(length, route, prizePool);
                break;
            case "Drag":
                race = new DragRace(length, route, prizePool);
                break;
            case "Drift":
                race = new DriftRace(length, route, prizePool);
                break;
        }
        addRaceToDatabase(id, race);
    }

    @Override
    public void participate(int carId, int raceId) {
        if (!idCarsMap.containsKey(carId)) {
            if (garage.getParkedCars().containsKey(carId)) {
              throw new InvalidCarParticipateException();
            }
            throw new InvalidCarIdException();
        }
        idRacesMap.get(raceId).addParticipants(carId, idCarsMap.get(carId));
    }

    @Override
    public String start(int id) {
        if (idRacesMap.get(id).getCountOfParticipants() < 1) {
            throw new InvalidCarRaceException();
        }
        String raceResults = idRacesMap.get(id).startRace();
        idRacesMap.remove(id);
        return raceResults;
    }

    @Override
    public void park(int id) {
        if (checkTheCarForParticipateInRace(id)) {
            throw new InvalidCarParkingException();
        }
        garage.addParkedCars(id, idCarsMap.get(id));
        idCarsMap.remove(id);
    }

    @Override
    public void unpark(int id) {
        if (!garage.getParkedCars().containsKey(id)) {
            throw new InvalidCarUnparkException();
        }
        idCarsMap.putIfAbsent(id, garage.getParkedCars().get(id));
        garage.unparkCar(id);
    }

    @Override
    public void tune(int tuneIndex, String addOn) {
        if (garage.getParkedCars().size() < 1) {
            throw new InvalidCarGarageException();
        }
        HashMap<Integer, Car> currentlyParkedCars = new HashMap<>(garage.getParkedCars());
        for (Integer carId : currentlyParkedCars.keySet()) {
            currentlyParkedCars.get(carId).tune(tuneIndex, addOn);
        }
    }

    private void addCarToDatabase(int id, Car car) {
        idCarsMap.putIfAbsent(id, car);
    }

    private void addRaceToDatabase(int id, Race race) {
        idRacesMap.putIfAbsent(id, race);
    }

    private boolean checkTheCarForParticipateInRace(int id) {
        boolean participate = false;
        for (Integer raceId : idRacesMap.keySet()) {
            if (idRacesMap.get(raceId).getParticipants().containsKey(id)) {
                participate = true;
            }
        }
        return participate;
    }
}
