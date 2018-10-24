package models.boats;

import Utility.Validator;
import contracts.Race;
import contracts.WindBoat;

public class RowBoat extends BaseBoat implements WindBoat {

    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight, false);
        this.setOars(oars);
    }

    private void setOars(int oars) {
        Validator.ValidatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    public int getOars() {
        return this.oars;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (this.getOars() * 100) - super.getWeight() + race.getOceanCurrentSpeed();
    }
}
