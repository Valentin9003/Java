package factory;

import entity.raceDto.*;

public final class RaceFactory {

    private RaceFactory() {
    }

    public static Race createRace(String type, int length, String route, int prizePool) {
        Race race = null;

        switch (type){
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

        return race;
    }

    public static Race createSpecialRace(String type, int length, String route, int prizePool, int extraParameter) {
        Race race = null;
        switch (type){
            case "TimeLimit":
                race = new TimeLimitRace(length, route, prizePool, extraParameter);
                break;
            case "Circuit":
                race = new CircuitRace(length, route, prizePool, extraParameter);
                break;
        }
        return race;
    }
}
