package com.company.models.raceModels;

import com.company.models.carsModels.Car;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class DragRace extends Race {

    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public HashMap<Car, Integer> getWinners() {
        HashMap<Car, Integer> winners = new LinkedHashMap<>();

        super.getParticipants().values().stream()
                .sorted((c1, c2) -> Integer.compare(c2.getEnginePerformance(), c1.getEnginePerformance()))
                .limit(3)
                .forEach(c -> {
                    winners.put(c, c.getEnginePerformance());
                });

        return winners;
    }

}
