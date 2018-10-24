package p05_speedRacing;

public class Car {

    private static final int DEFAULT_DISTANCE_TRAVELED = 0;

    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int distanceTraveled;

    public Car() {
    }

    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTraveled = DEFAULT_DISTANCE_TRAVELED;
    }

    public void drive(double kilometers) {
        if (canMoveThatDistance(kilometers)) {
            traveling(kilometers);
        } else {
            throw new IllegalArgumentException("Insufficient fuel for the drive");
        }
    }

    private void traveling(double kilometers) {
        this.fuelAmount -= kilometers * fuelCostPerKm;
        this.distanceTraveled += kilometers;
    }

    private boolean canMoveThatDistance(double kilometers) {
        double posibleDistance = this.fuelAmount / this.fuelCostPerKm;
        return posibleDistance >= kilometers;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
