package entity.garageDto;

import entity.carsDto.Car;

import java.util.*;

public class Garage {

    private Map<Integer, Car> parkedCars;

    public Garage() {
        this.parkedCars = new LinkedHashMap<>();
    }

    public Map<Integer, Car> getParkedCars() {
        return Collections.unmodifiableMap(this.parkedCars);
    }

    public void parkingCar(int id, Car car) {
        this.parkedCars.put(id, car);
    }

    public void unparkCar(int id) {
        this.parkedCars.remove(id);
    }

    public boolean containsCar(int id) {
        return this.getParkedCars().containsKey(id);
    }

    public void tuneCars(int tuneIndex, String tuneAddOn) {
        for (Car car : parkedCars.values()) {
            car.tune(tuneIndex, tuneAddOn);
        }

    }
}
