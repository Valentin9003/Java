package p06_rawData.models;

import java.util.Collections;
import java.util.List;

public class Car {

    private static final int TIRES_COUNT = 4;

    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car() {
    }

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public static int getTiresCount() {
        return TIRES_COUNT;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Tire> getTires() {
        return Collections.unmodifiableList(this.tires);
    }

    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }

    @Override
    public String toString() {
        return String.format("%s", this.getModel());
    }
}
