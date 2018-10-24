package com.company.ferrari;

public class Ferrari implements Car {

    public static final String DEFAULT_MODEL = "488-Spider";

    private String model;
    private String driver;

    public Ferrari(String driver) {
        this.driver = driver;
        this.setModel(DEFAULT_MODEL);
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushTheGasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return (String.format("%s/%s/%s/%s", this.model, this.useBrakes(), this.pushTheGasPedal(), this.driver));
    }
}
