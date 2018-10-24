package entity.raceDto;

import entity.carsDto.Car;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CircuitRace extends Race {

    private final int FIRST_PLACE_PRIZE = 40;
    private final int SECOND_PLACE_PRIZE = 30;
    private final int THIRD_PLACE_PRIZE = 20;
    private final int FOURTH_PLACE_PRIZE = 10;

    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    @Override
    public int calculaterPrize(int place) {
        switch (place) {
            case 1:
                return this.getPrizePool() * FIRST_PLACE_PRIZE / 100;
            case 2:
                return this.getPrizePool() * SECOND_PLACE_PRIZE / 100;
            case 3:
                return this.getPrizePool() * THIRD_PLACE_PRIZE / 100;
            default:
                return this.getPrizePool() * FOURTH_PLACE_PRIZE / 100;
        }
    }

    @Override
    public String startRace() {
        List<Car> raceResult = new LinkedList<>();
        for (int i = 0; i < this.laps; i++) {
            raceResult = raceTheLap();
            decreaseDurabilityOfEachParticipant(raceResult);
        }

        return createResultString(raceResult);
    }

    private List<Car> raceTheLap() {
        return this.getParticipants()
                    .stream()
                    .sorted((c1, c2) -> Integer.compare(c2.getOverallPerformance(), c1.getOverallPerformance()))
                    .collect(Collectors.toList());
    }

    private void decreaseDurabilityOfEachParticipant(List<Car> raceResult) {
        raceResult
                .forEach(car -> car.decreaseDurability(this.getLength() * this.getLength()));
    }

    private String createResultString(List<Car> raceResult) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s - %d", this.getRoute(), this.getLength() * this.laps));

        for (int place = 1; place <= 4; place++) {
            sb.append(System.lineSeparator())
                    .append(String.format("%d. %s %s %dPP - $%d",
                            place,
                            raceResult.get(place - 1).getBrand(),
                            raceResult.get(place - 1).getModel(),
                            raceResult.get(place - 1).getOverallPerformance(),
                            this.calculaterPrize(place)));
        }

        return sb.toString();
    }
}
