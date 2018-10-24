package p03_ferrari.models.impl;

public class Ferrari extends BaseCar {

    private static final String MODEL = "488-Spider";

    private String driverName;

    public Ferrari(String driverName) {
        super(MODEL);
        this.driverName = driverName;
    }

    public String getDriverName() {
        return this.driverName;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",
                this.getModel(),
                this.useBrakes(),
                this.pushTheGas(),
                this.getDriverName());
    }
}
