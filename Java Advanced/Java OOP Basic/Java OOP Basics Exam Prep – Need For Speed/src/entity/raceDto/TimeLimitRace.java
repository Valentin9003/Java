package entity.raceDto;

import entity.carsDto.Car;

public class TimeLimitRace extends Race {

    private final int GOLD_TIME_PRIZE_PERCENTE = 100;
    private final int SILVER_TIME_PRIZE_PERCENTE = 50;
    private final int BRONZE_TIME_PRIZE_PERCENTE = 30;
    private final String GOLD_TIME = "Gold Time";
    private final String SILVER_TIME = "Silver Time";
    private final String BRONZE_TIME = "Bronze Time";

    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }

    public int getGoldTime() {
        return this.goldTime;
    }

    @Override
    public int calculaterPrize(int timePerformance) {
        //TP <= raceGoldTime – Racer has earned Gold Time and earns 100% of the prizePool.
        //TP <= raceGoldTime + 15 – Racer has earned Silver Time and earns 50% of the prizePool.
        //TP > raceGoldTime + 15 – Racer has earned Bronze Time and earns 30% of the prizePool.
        if (timePerformance <= this.getGoldTime()) {
            return this.getPrizePool() * GOLD_TIME_PRIZE_PERCENTE / 100;
        } else if (timePerformance <= (this.getGoldTime() + 15)) {
            return this.getPrizePool() * SILVER_TIME_PRIZE_PERCENTE / 100;
        } else {
            return this.getPrizePool() * BRONZE_TIME_PRIZE_PERCENTE / 100;
        }
    }

    @Override
    public void addParticipation(Car car) {
        //The TimeLimitRace can only have 1 participant.
        //ANY attempt to add more participants to it should be IGNORED.
        if (super.getParticipants().size() == 0) {
            super.addParticipation(car);
        }
    }

    @Override
    public String startRace() {
        Car participant = this.getParticipants().get(0);
        int participantTimePerformance = participant.getTimePerformance(this.getLength());
        int wonPrize = calculaterPrize(participantTimePerformance);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %d", this.getRoute(), this.getLength()))
                .append(System.lineSeparator())
                .append(String.format("%s %s - %d s.",
                        participant.getBrand(),
                        participant.getModel(),
                        participantTimePerformance))
                .append(System.lineSeparator())
                .append(String.format("%s, $%d.",
                        participantTimePerformance <= this.getGoldTime() ? GOLD_TIME :
                            participantTimePerformance <= this.getGoldTime() + 15 ? SILVER_TIME :
                                BRONZE_TIME,
                        wonPrize));

        return sb.toString();
    }
}
