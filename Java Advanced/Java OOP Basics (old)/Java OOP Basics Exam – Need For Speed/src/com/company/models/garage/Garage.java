package com.company.models.garage;

import com.company.models.carsModels.Car;

import java.util.HashMap;

public class Garage {

    private HashMap<Integer, Car> parkedCars;

    public Garage() {
        this.parkedCars = new HashMap<>();
    }

    public HashMap<Integer, Car> getParkedCars() {
        return parkedCars;
    }

    public void addParkedCars(int carId, Car car) {
        parkedCars.putIfAbsent(carId, car);
    }

    public void unparkCar(int id) {
        parkedCars.remove(id);
    }
}
