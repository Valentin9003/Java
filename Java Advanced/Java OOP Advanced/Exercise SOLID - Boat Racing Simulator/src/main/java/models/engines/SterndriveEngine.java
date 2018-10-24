package models.engines;

public class SterndriveEngine extends BaseEngine {

    private static final int MULTIPLIER = 7;

    public SterndriveEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    public double output() {
        if (super.getCachedOutput() != 0) {
            return super.getCachedOutput();
        }
        super.setCachedOutput((super.getHorsepower() * MULTIPLIER) + super.getDisplacement());
        return super.getCachedOutput();
    }
}
