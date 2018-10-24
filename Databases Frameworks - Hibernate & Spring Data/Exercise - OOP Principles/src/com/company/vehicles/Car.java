package com.company.vehicles;

public class Car extends Vehicles{

    private static final double INCREASED_SUMMER_FUEL_CONSUMPTION_PER_KM = 0.9D;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void driven(double distance) {
        double summerConsumption = this.getFuelConsumption() + INCREASED_SUMMER_FUEL_CONSUMPTION_PER_KM;
        double maxDistanceWithThisFuel = this.getFuelQuantity() / summerConsumption;
        if (distance > maxDistanceWithThisFuel) {
            System.out.println("Car needs refueling");
        } else {
            double needFuel = distance * summerConsumption;
            double leftFuel = this.getFuelQuantity() - needFuel;
            this.setFuelQuantity(leftFuel);
            System.out.println(String.format("Car travelled %s km", this.df.format(distance)));
        }
    }

    @Override
    public void refuel(double liters) {
        double buffer = liters + this.getFuelQuantity();
        this.setFuelQuantity(buffer);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", this.getFuelQuantity());
    }
}
