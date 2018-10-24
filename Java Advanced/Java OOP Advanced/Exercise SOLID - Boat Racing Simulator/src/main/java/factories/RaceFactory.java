package factories;

import contracts.Race;
import models.races.RaceImpl;

public final class RaceFactory {

    private RaceFactory() {
    }

    public static Race create(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowsMotorboats) {
        return new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
    }
}
