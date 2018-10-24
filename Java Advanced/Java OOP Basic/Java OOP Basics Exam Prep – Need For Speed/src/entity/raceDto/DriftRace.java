package entity.raceDto;

import entity.carsDto.Car;

import java.util.List;
import java.util.stream.Collectors;

public class DriftRace extends Race {

    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String startRace() {
        List<Car> raceResult = this.getParticipants()
                .stream()
                .sorted((c1,c2) -> Integer.compare(c2.getSuspensionPerformance(), c1.getSuspensionPerformance()))
                .limit(3)
                .collect(Collectors.toList());

        return createResultString(raceResult);
    }

    private String createResultString(List<Car> raceResult) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %d", this.getRoute(), this.getLength()))
                .append(System.lineSeparator());

        int place = 1;
        for (Car car : raceResult) {
            sb.append(String.format("%d. %s %s %dPP - $%d",
                    place,
                    car.getBrand(),
                    car.getModel(),
                    car.getSuspensionPerformance(),
                    super.calculaterPrize(place)));
            if (place < raceResult.size()) {
                sb.append(System.lineSeparator());
            }
            place++;
        }
        return sb.toString();
    }
}
