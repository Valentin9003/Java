package p09_trafficLights;

public enum Signal {
    RED,
    GREEN,
    YELLOW;

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
