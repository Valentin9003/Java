package p09_trafficLights;

public class TrafficMachine {

    private Signal signal;

    public TrafficMachine(String signal) {
        this.signal = Enum.valueOf(Signal.class, signal.toUpperCase());
    }

    public void changeLight() {
        int currentSignalIndex = this.signal.ordinal();
        int nextLightIndex = (currentSignalIndex + 1) % 3;

        this.signal = Signal.values()[nextLightIndex];
    }

    @Override
    public String toString() {
        return signal.name();
    }
}
