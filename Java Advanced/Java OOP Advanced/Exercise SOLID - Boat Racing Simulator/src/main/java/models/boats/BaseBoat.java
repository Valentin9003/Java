package models.boats;

import Utility.Constants;
import Utility.Validator;
import contracts.Boat;

import java.util.Objects;

public abstract class BaseBoat implements Boat {

    private String model;
    private int weight;
    private boolean isMotorBoat;

    protected BaseBoat(String model, int weight, boolean isMotorBoat) {
        this.setModel(model);
        this.setWeight(weight);
        this.isMotorBoat = isMotorBoat;
    }

    private void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MIN_BOAT_MODEL_LENGTH);
        this.model = model;
    }

    private void setWeight(int weight) {
        Validator.ValidatePropertyValue(weight, "Weight");
        this.weight = weight;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public boolean isMotorBoat() {
        return this.isMotorBoat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseBoat)) return false;
        BaseBoat baseBoat = (BaseBoat) o;
        return Objects.equals(getModel(), baseBoat.getModel());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getModel());
    }
}
