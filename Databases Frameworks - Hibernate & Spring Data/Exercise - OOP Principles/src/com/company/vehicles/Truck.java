package com.company.vehicles;

public class Truck extends Vehicles {

    private static final double INCREASED_SUMMER_FUEL_CONSUMPTION_PER_KM = 1.6D;
    private static final double DEFAULT_REFUELING_CAPACITY = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void driven(double distance) {
        double summerConsumption = this.getFuelConsumption() + INCREASED_SUMMER_FUEL_CONSUMPTION_PER_KM;
        double maxDistanceWithThisFuel = this.getFuelQuantity() / summerConsumption;
        if (distance > maxDistanceWithThisFuel) {
            System.out.println("Truck needs refueling");
        } else {
            double needFuel = distance * summerConsumption;
            double leftFuel = this.getFuelQuantity() - needFuel;
            this.setFuelQuantity(leftFuel);
            System.out.println(String.format("Truck travelled %s km", this.df.format(distance)));
        }
    }

    @Override
    public void refuel(double liters) {
        double buffer = (liters * DEFAULT_REFUELING_CAPACITY) + this.getFuelQuantity();
        this.setFuelQuantity(buffer);
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", this.getFuelQuantity());
    }
}
