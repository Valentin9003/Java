package models.engines;

import Utility.Constants;
import Utility.Validator;
import contracts.Engine;

public abstract class BaseEngine implements Engine {

    private String model;

    private int horsepower;

    private int displacement;

    private int cachedOutput;

    public BaseEngine(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    private void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
        this.model = model;
    }

    private void setHorsepower(int horsepower) {
        Validator.ValidatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    private void setDisplacement(int displacement) {
        Validator.ValidatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }

    protected int getCachedOutput() {
        return this.cachedOutput;
    }

    protected void setCachedOutput(int cachedOutput) {
        this.cachedOutput = cachedOutput;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public int getDisplacement() {
        return displacement;
    }

}
