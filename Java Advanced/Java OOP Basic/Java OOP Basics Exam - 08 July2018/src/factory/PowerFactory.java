package factory;

import entity.interfaces.SuperPower;
import entity.power.Power;

public final class PowerFactory {

    private PowerFactory() {
    }

    public static SuperPower createPower(String superPowerName, double powerPoints) {
        return new Power(superPowerName, powerPoints);
    }
}
