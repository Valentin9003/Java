package p03_ferrari.models.impl;

import p03_ferrari.models.contracts.Car;

public abstract class BaseCar implements Car {

    private static final String DEFAULT_BRAKES = "Brakes!";
    private static final String DEFAULT_GAS = "Zadu6avam sA!";

    private String model;

    public BaseCar(String model) {
        this.model = model;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String useBrakes() {
        return DEFAULT_BRAKES;
    }

    @Override
    public String pushTheGas() {
        return DEFAULT_GAS;
    }

}
