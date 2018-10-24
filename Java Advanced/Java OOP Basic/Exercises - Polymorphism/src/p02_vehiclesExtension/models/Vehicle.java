package p02_vehiclesExtension.models;

import p02_vehiclesExtension.models.interfaces.IVenhile;
import p02_vehiclesExtension.util.ConfigExMessage;

public abstract class Vehicle implements IVenhile {

    private double fuelQuantity;
    private double litersPerKm;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double litersPerKm, double tankCapacity) {
        this.setTankCapacity(tankCapacity);
        this.setFuelQuantity(fuelQuantity);
        this.setLitersPerKm(litersPerKm);
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
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
        if (fuelQuantity > this.getTankCapacity()) {
            throw new IllegalArgumentException(ConfigExMessage.INVALID_LITTERS_QUANTITY_EX_MESSAGE);
        }
        this.fuelQuantity = fuelQuantity;
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public double getLitersPerKm() {
        return this.litersPerKm;
    }

    @Override
    public abstract String drive(double distance);

    @Override
    public abstract String drive(double distance, boolean isEmpty);

    @Override
    public abstract void refuel(double liters);
}
