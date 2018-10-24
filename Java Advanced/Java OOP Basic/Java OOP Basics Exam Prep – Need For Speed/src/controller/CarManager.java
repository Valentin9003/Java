package controller;

import entity.carsDto.Car;
import entity.garageDto.Garage;
import entity.raceDto.Race;
import factory.CarFactory;
import factory.RaceFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarManager implements Manager {

    private Map<Integer, Car> carsDB;
    private Map<Integer, Race> racesDB;
    private Garage garage;

    public CarManager() {
        this.carsDB = new LinkedHashMap<>();
        this.racesDB = new LinkedHashMap<>();
        this.garage = new Garage();
    }

    @Override
    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        /** REGISTERS a car of the given type, with the given id, and the given stats.
         o	The car type will be either “Performance” or “Show”.*/
        Car car = CarFactory.creatCar(type, brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        carsDB.putIfAbsent(id, car);
    }

    @Override
    public String check(int id) {
        /**  CHECKS details about the car with the given id.
         o	RETURNS a string representation of the car.*/
        if (!this.carsDB.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        return this.carsDB.get(id).toString();
    }

    @Override
    public void open(int id, String type, int length, String route, int prizePool) {
        /** OPENS a race of the given type, with the given id, and stats.
         o	The race type will be either “Casual”, “Drag” or “Drift”.*/
        Race race = RaceFactory.createRace(type, length, route, prizePool);
        this.racesDB.putIfAbsent(id, race);
    }

    @Override
    public void open(int id, String type, int length, String route, int prizePool, int extraParameter) {
        /** OPENS a race of the given type, with the given id, and stats.
         o	BONUS Task - add 2 new special races */
        Race race = RaceFactory.createSpecialRace(type, length, route, prizePool, extraParameter);
        this.racesDB.putIfAbsent(id, race);
    }

    @Override
    public void participate(int carId, int raceId) {
        /** ADDS a car as a participant in the given race.
         o	Once added, a car CANNOT turn down a race or be REMOVED from it.*/
        if (!this.garage.containsCar(carId)) {
            Car car = this.carsDB.get(carId);
            this.racesDB.get(raceId).addParticipation(car);
        }
    }

    @Override
    public String start(int id) {
        /** INITIATES the race with the given id.
         o	RETURNS detailed information about the race result.*/
        //A race CANNOT start without ANY participants.
        //A race CAN start with LESS than three participants.

        if (this.racesDB.get(id).hasZeroParticipants()) {
            throw new IllegalArgumentException("Cannot start the race with zero participants.");
        }
        String raceResult = this.racesDB.get(id).startRace();
        this.racesDB.remove(id);
        return raceResult;
    }

    @Override
    public void park(int id) {
        /** o	PARKS a car by a given id in the garage.*/
        //Once a car has been ADDED as a participant in a race,
        // it CANNOT be PARKED in the garage, UNTIL the race is OVER.

        if (isParticipantInTheRace(id)) {
            throw new IllegalArgumentException("The car Participate in the race and cannot be parking");
        }
        this.garage.parkingCar(id, this.carsDB.get(id));
    }

    @Override
    public void unpark(int id) {
        /** UNPARKS the car with the given id from the garage.*/
        this.garage.unparkCar(id);
    }

    @Override
    public void tune(int tuneIndex, String addOn) {
        /** Tunes the currently parked CARS with the given index and the given add-on.
         o	You should increase a car’s horsepower by the given index, and the suspension, by HALF of the given index.
         –	150 tuneIndex = 150 increase in the horsepower and 75 increase in suspension.

         o	If the car is a ShowCar it should increase its stars by the given tuneIndex.
         o	Upon tuning, a PerformanceCar adds the given add-on to its collection of add-ons.
         */

        this.garage.tuneCars(tuneIndex, addOn);
    }

    private boolean isParticipantInTheRace(int id) {
        Car car = this.carsDB.get(id);
        boolean isParticipant = false;
        for (Race race : racesDB.values()) {
            if (race.getParticipants().contains(car)) {
                isParticipant = true;
            }
        }
        return isParticipant;
    }
}
