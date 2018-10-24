package com.company.Car;

public class Car {

    private double speed;
    private double fuel;
    private double fuelEconomy;
    private double distanceTravelled;
    private double timeTravelled;

    public Car(double speed, double fuel, double fuelEconomy) {
        this.setSpeed(speed);
        this.setFuel(fuel);
        this.setFuelEconomy(fuelEconomy);
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public double getTimeTravelled() {
        return timeTravelled;
    }

    public double getFuel() {
        return fuel;
    }

    private void setFuel(double fuel) {
        if (fuel < 0) {
            throw new IllegalArgumentException("Fuel cannot be negative!");
        }

        this.fuel = fuel;
    }

    private void setSpeed(double speed) {
        if (speed < 0) {
            throw new IllegalArgumentException("Speed cannot be negative!");
        }

        this.speed = speed;
    }

    private void setFuelEconomy(double fuelEconomy) {
        if (fuelEconomy < 0) {
            throw new IllegalArgumentException("Fuel Economy cannot be negative!");
        }
        this.fuelEconomy = fuelEconomy;
    }


    public void travel(double distance) {
        double possibleDistance = distance;
        if (distance > this.calculatePossibleDistance()) {
            possibleDistance = this.calculatePossibleDistance();
        }

        this.distanceTravelled += possibleDistance;
        this.setFuel(calculateUsedFuel(possibleDistance));
        this.timeTravelled = calculateTimeForTravelling(possibleDistance);
    }

    private double calculateTimeForTravelling(double possibleDistance) {
        return possibleDistance / this.speed;
    }

    private double calculateUsedFuel(double possibleDistance) {
        return this.fuel - (possibleDistance * fuelEconomy / 100);
    }

    private double calculatePossibleDistance() {
        return fuel / fuelEconomy * 100;
    }

}
