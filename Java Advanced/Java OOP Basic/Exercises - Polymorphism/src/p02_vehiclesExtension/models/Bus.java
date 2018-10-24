package p02_vehiclesExtension.models;

import p02_vehiclesExtension.util.ConfigExMessage;

import java.text.DecimalFormat;

public final class Bus extends Vehicle {

    private static final double AIR_CONDITIONER_CONSUMPTION_INCREASED_PER_KM = 1.4F;

    public Bus(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity);
    }

    private void haveItPossibilityForDrive(double neededFuel) {
        if (this.getFuelQuantity() < neededFuel) {
            throw new IllegalArgumentException(
                    String.format(ConfigExMessage.VEHICLE_NEED_REFUELING_EX_MESSAGE,
                            this.getClass().getSimpleName()));
        }
    }

    @Override
    public String drive(double distance) {
        double neededFuel =
                distance * (this.getLitersPerKm() + AIR_CONDITIONER_CONSUMPTION_INCREASED_PER_KM);

        haveItPossibilityForDrive(neededFuel);

        this.setFuelQuantity(this.getFuelQuantity() - neededFuel);

        return String.format(ConfigExMessage.TRAVELLED_MESSAGE,
                this.getClass().getSimpleName(),
                new DecimalFormat("#########0.##").format(distance));
    }

    @Override
    public String drive(double distance, boolean isEmpty) {
        double neededFuel = distance * this.getLitersPerKm();

        haveItPossibilityForDrive(neededFuel);

        this.setFuelQuantity(this.getFuelQuantity() - neededFuel);

        return String.format(ConfigExMessage.TRAVELLED_MESSAGE,
                this.getClass().getSimpleName(),
                new DecimalFormat("#########0.##").format(distance));
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException(ConfigExMessage.INVALID_FUEL_QUANTITY_EX_MESSAGE);
        }
        super.setFuelQuantity(super.getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %s",
                this.getClass().getSimpleName(),
                new DecimalFormat("#########0.00").format(this.getFuelQuantity()));
    }
}
