package com.company.interfaces;
import com.company.models.carsModels.Car;

import java.util.HashMap;

public interface IRace {

    void addParticipants(int carId, Car car);

    String startRace();

    HashMap<Car, Integer> getWinners();
}
