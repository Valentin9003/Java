package p01_vehicles.models;

import p01_vehicles.models.interfaces.IVenhile;
import p01_vehicles.util.ConfigExMessage;

public abstract class Vehicle implements IVenhile {

    private double fuelQuantity;
    private double litersPerKm;

    public Vehicle(double fuelQuantity, double litersPerKm) {
        this.setFuelQuantity(fuelQuantity);
        this.setLitersPerKm(litersPerKm);
    }

    private void setLitersPerKm(double litersPerKm) {
        if (litersPerKm < 0) {
            throw new IllegalArgumentException(ConfigExMessage.INVALID_LITTERS_PER_KM_EX_MESSAGE);
        }
        this.litersPerKm = litersPerKm;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0) {
            throw new IllegalArgumentException(ConfigExMessage.INVALID_FUEL_QUANTITY_EX_MESSAGE);
        }
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getLitersPerKm() {
        return litersPerKm;
    }

    @Override
    public abstract String drive(double distance);

    @Override
    public abstract void refuel(double liters);

}
