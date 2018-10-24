package com.company.vehicles;

import java.text.DecimalFormat;

public abstract class Vehicles {

    private double fuelQuantity;
    private double fuelConsumption;
    protected DecimalFormat df;

    public Vehicles(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        df = new DecimalFormat("#######.################");
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    private void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public abstract void driven(double distance);

    public abstract void refuel(double liters);
}
