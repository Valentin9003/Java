package entity.power;

import entity.interfaces.SuperPower;

public class Power implements SuperPower {

    private String name;
    private double powerPoints;

    public Power(String name, double powerPoints) {
        this.setName(name);
        this.setPowerPoints(powerPoints);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (!name.matches("(@[A-Za-z_]{3,}@)")) {
            throw new IllegalArgumentException("Super power name not in the correct format!");
        }
        this.name = name;
    }

    public double getPowerPoints() {
        return this.powerPoints;
    }

    private void setPowerPoints(double powerPoints) {
        if (powerPoints < 0) {
            throw new IllegalArgumentException("Power points should be a possitive number!");
        }
        this.powerPoints = powerPoints;
    }
}
