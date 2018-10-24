package models.boats;

import Utility.Constants;
import contracts.Race;
import contracts.WindBoat;

public class SailBoat extends BaseBoat implements WindBoat {

    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight, false);
        this.setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new IllegalArgumentException(Constants.INCORRECT_SAIL_EFFICIENCY_MESSAGE);
        }
        this.sailEfficiency = sailEfficiency;
    }

    public int getSailEfficiency() {
        return this.sailEfficiency;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (race.getWindSpeed() * (this.getSailEfficiency() / 100d)) - super.getWeight() + (race.getOceanCurrentSpeed() / 2d);
    }
}
