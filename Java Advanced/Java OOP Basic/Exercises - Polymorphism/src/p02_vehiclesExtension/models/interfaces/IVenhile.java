package p02_vehiclesExtension.models.interfaces;

public interface IVenhile {

    String drive(double distance);

    String drive(double distance, boolean isEmpty);

    void refuel(double liters);
}
