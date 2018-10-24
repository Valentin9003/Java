package entity.raceDto;

import entity.carsDto.Car;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class Race {

    private final int FIRST_PLACE_PRIZE_PERCENT = 50;
    private final int SECOND_PLACE_PRIZE_PERCENT = 30;
    private final int THIRD_PLACE_PRIZE_PERCENT = 20;

    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    public Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new LinkedList<>();
    }

    public int getLength() {
        return this.length;
    }

    public String getRoute() {
        return this.route;
    }

    public int getPrizePool() {
        return this.prizePool;
    }

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }

    public void addParticipation(Car car) {
        this.participants.add(car);
    }

    public boolean hasZeroParticipants() {
        return this.getParticipants().size() == 0;
    }

    public int calculaterPrize(int place) {
        switch (place){
            case 1:
                return this.prizePool * FIRST_PLACE_PRIZE_PERCENT / 100;
            case 2:
                return this.prizePool * SECOND_PLACE_PRIZE_PERCENT / 100;
            default:
                return this.prizePool * THIRD_PLACE_PRIZE_PERCENT / 100;
        }
    }

    public abstract String startRace();
}
