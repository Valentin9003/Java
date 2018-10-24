package models.boats;

import contracts.Engine;
import contracts.MotorBoat;
import contracts.Race;

public class PowerBoat extends BaseBoat implements MotorBoat {

    private Engine firstEngine;

    private Engine secondEngine;

    public PowerBoat(String model, int weight, Engine firstEngine, Engine secondEngine) {
        super(model, weight, true);
        this.firstEngine = firstEngine;
        this.secondEngine = secondEngine;
    }

    public Engine getFirstEngine() {
        return this.firstEngine;
    }

    public Engine getSecondEngine() {
        return this.secondEngine;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (this.firstEngine.output() + this.secondEngine.output()) - super.getWeight() + (race.getOceanCurrentSpeed() / 5d);
    }
}
