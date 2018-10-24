package models.boats;

import Utility.Validator;
import contracts.Engine;
import contracts.MotorBoat;
import contracts.Race;

public class Yacht extends BaseBoat implements MotorBoat {

    private int cargoWeight;
    private Engine engine;

    public Yacht(String model, int weight, int cargoWeight, Engine engine) {
        super(model, weight, true);
        this.setCargoWeight(cargoWeight);
        this.engine = engine;
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.ValidatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    public int getCargoWeight() {
        return this.cargoWeight;
    }

    public Engine getEngine() {
        return this.engine;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return this.engine.output() - super.getWeight() - this.getCargoWeight() + (race.getOceanCurrentSpeed() / 2d);
    }
}
