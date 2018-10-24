package p07_CarSalesman.models;

public class Car {

    private static final String DEFAULT_COLOR = "n/a";
    private static final int DEFAULT_WEIGHT = 0;
    private static final String DEFAULT_WEIGHT_STRING = "n/a";

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car() {
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, DEFAULT_COLOR);
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, DEFAULT_WEIGHT, color);
    }

    public Car(String model, Engine engine) {
        this(model, engine, DEFAULT_WEIGHT, DEFAULT_COLOR);
    }

    @Override
    public String toString() {
        StringBuilder carBuilder = new StringBuilder();
        carBuilder.append(String.format("%s:", this.model))
                .append(System.lineSeparator())
                .append(this.engine)
                .append(System.lineSeparator())
                .append("Weight: ")
                .append(this.weight == DEFAULT_WEIGHT ? DEFAULT_WEIGHT_STRING : this.weight)
                .append(System.lineSeparator())
                .append(String.format("Color: %s", this.color))
                .append(System.lineSeparator());

        return carBuilder.toString();
    }
}
