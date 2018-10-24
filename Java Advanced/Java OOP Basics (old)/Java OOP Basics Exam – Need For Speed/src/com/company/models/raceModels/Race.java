package com.company.models.raceModels;

import com.company.exceptions.InvalidRaceLengthException;
import com.company.exceptions.InvalidRacePrizePoolException;
import com.company.exceptions.InvalidRaceRouteException;
import com.company.interfaces.IRace;
import com.company.models.carsModels.Car;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Race implements IRace {

    private int length;
    private String route;
    private int prizePool;
    private LinkedHashMap<Integer, Car> participants;

    public Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new LinkedHashMap<>();
    }

    public LinkedHashMap<Integer, Car> getParticipants() {
        return participants;
    }

    public int getCountOfParticipants() {
        return participants.size();
    }

    @Override
    public void addParticipants(int carId, Car car) {
        this.participants.putIfAbsent(carId, car);
    }

    @Override
    public String startRace() {
        HashMap<Car, Integer> winners = this.getWinners();

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %s", this.getRoute(), this.getLength()))
                .append(System.lineSeparator());

        int[] prices = getPrices();
        int index = 1;
        for (Map.Entry<Car, Integer> carIntegerEntry : winners.entrySet()) {
            Car car = carIntegerEntry.getKey();
            sb.append(String.format("%s. %s %s %sPP - $%s",
                    index,
                    car.getBrand(),
                    car.getModel(),
                    carIntegerEntry.getValue(),
                    prices[index - 1]))
                    .append(System.lineSeparator());
            index++;
        }

        participants.clear();
        this.participants = new LinkedHashMap<>();

        return sb.toString().trim();
    }

    public int getLength() {
        return length;
    }

    public String getRoute() {
        return route;
    }

    public int getPrizePool() {
        return prizePool;
    }

    @Override
    public abstract HashMap<Car, Integer> getWinners();

    private void setLength(int length) {
        if (length < 0 || length > 100000) {
            throw new InvalidRaceLengthException();
        }
        this.length = length;
    }

    private void setRoute(String route) {
        if (route == null || route.isEmpty()) {
            throw new InvalidRaceRouteException();
        }
        this.route = route;
    }

    private void setPrizePool(int prizePool) {
        if (prizePool < 0 || prizePool > 100000) {
            throw new InvalidRacePrizePoolException();
        }
        this.prizePool = prizePool;
    }

    private int[] getPrices() {
        int[] prices = new int[3];
        prices[0] = (this.getPrizePool() * 50) / 100;
        prices[1] = (this.getPrizePool() * 30) / 100;
        prices[2] = (this.getPrizePool() * 20) / 100;
        return prices;
    }
}
