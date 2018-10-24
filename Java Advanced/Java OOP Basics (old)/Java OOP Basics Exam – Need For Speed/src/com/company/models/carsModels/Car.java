package com.company.models.carsModels;

import com.company.exceptions.*;
import com.company.interfaces.ICar;

public abstract class Car implements ICar {

    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    Car(String brand,
        String model,
        int yearOfProduction,
        int horsepower,
        int acceleration,
        int suspension,
        int durability) {

        this.setBrand(brand);
        this.setModel(model);
        this.setYearOfProduction(yearOfProduction);
        this.setHorsepower(horsepower);
        this.setAcceleration(acceleration);
        this.setSuspension(suspension);
        this.setDurability(durability);
    }

    @Override
    public int getOverallPerformance() {
        // (horsepower / acceleration) + (suspension + durability)
        return (this.getHorsepower() / this.getAcceleration()) + (this.getSuspension() + this.getDurability());
    }

    @Override
    public int getEnginePerformance() {
        // (horsepower / acceleration)
        return this.getHorsepower() / this.getAcceleration();
    }

    @Override
    public int getSuspensionPerformance() {
        // (suspension + durability)
        return this.getSuspension() + this.getDurability();
    }

    @Override
    public abstract String toString();

    @Override
    public abstract void tune(int tuneIndex, String tuneAddOn);

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getSuspension() {
        return suspension;
    }

    int getYearOfProduction() {
        return yearOfProduction;
    }

    int getHorsepower() {
        return horsepower;
    }

    int getAcceleration() {
        return acceleration;
    }

    int getDurability() {
        return durability;
    }

    void setHorsepower(int horsepower) {
        if (horsepower < 0 || horsepower > 100000) {
            throw new InvalidCarHorsePowerException();
        }
        this.horsepower = horsepower;
    }

    void setSuspension(int suspension) {
        if (suspension < 0 || suspension > 100000) {
            throw new InvalidCarSuspensionException();
        }
        this.suspension = suspension;
    }

    private void setBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            throw new InvalidCarBrandException();
        }
        this.brand = brand;
    }

    private void setModel(String model) {
        if (model == null || model.isEmpty()) {
            throw new InvalidCarModelException();
        }
        this.model = model;
    }

    private void setYearOfProduction(int yearOfProduction) {
        if (yearOfProduction < 0 || yearOfProduction > 100000) {
            throw new InvalidCarYearException();
        }
        this.yearOfProduction = yearOfProduction;
    }

    private void setAcceleration(int acceleration) {
        if (acceleration < 0 || acceleration > 100000) {
            throw new InvalidCarAccelerationException();
        }
        this.acceleration = acceleration;
    }

    private void setDurability(int durability) {
        if (durability < 0 || durability > 100000) {
            throw new InvalidCarDurabilityException();
        }
        this.durability = durability;
    }
}
