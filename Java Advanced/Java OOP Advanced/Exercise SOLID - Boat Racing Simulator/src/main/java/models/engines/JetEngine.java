package models.engines;

public class JetEngine extends BaseEngine {

    private static final int MULTIPLIER = 5;

    public JetEngine(String model, int horsepower, int displacement) {
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
