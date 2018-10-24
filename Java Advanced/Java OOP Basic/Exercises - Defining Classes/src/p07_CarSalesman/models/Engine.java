package p07_CarSalesman.models;

public class Engine {

    private static final String DEFAULT_EFFICIENCY = "n/a";
    private static final int DEFAULT_DISPLACEMENT = 0;
    private static final String DEFAULT_DISPLACEMENT_STRING = "n/a";

    private String model;
    private int power;
    private int displacement;  //optional
    private String efficiency; //optional

    public Engine() {
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, DEFAULT_EFFICIENCY);
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, DEFAULT_DISPLACEMENT, efficiency);
    }

    public Engine(String model, int power) {
        this(model, power, DEFAULT_DISPLACEMENT, DEFAULT_EFFICIENCY);
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        StringBuilder engineBuilder = new StringBuilder();
        engineBuilder.append(String.format("%s:", this.model))
                .append(System.lineSeparator())
                .append(String.format("Power: %d", this.power))
                .append(System.lineSeparator())
                .append("Displacement: ")
                .append(this.displacement == DEFAULT_DISPLACEMENT ? DEFAULT_DISPLACEMENT_STRING : this.displacement)
                .append(System.lineSeparator())
                .append(String.format("Efficiency: %s", this.efficiency));

        return engineBuilder.toString();
    }
}
