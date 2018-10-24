package entity.carsDto;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PerformanceCar extends Car {

    private final int DEFAULT_INCREASE_HORSEPOWER_PERCENT = 50;
    private final int DEFAULT_DECREASE_SUSPENSION_PERCENT = 25;

    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new LinkedList<>();
    }

    @Override
    protected void setHorsepower(int horsepower) {
        horsepower += (horsepower * DEFAULT_INCREASE_HORSEPOWER_PERCENT) / 100;
        super.setHorsepower(horsepower);
    }

    @Override
    protected void setSuspension(int suspension) {
        suspension -= (suspension * DEFAULT_DECREASE_SUSPENSION_PERCENT) / 100;
        super.setSuspension(suspension);
    }

    @Override
    public void tune(int tuneIndex, String tuneAddOn) {
        super.tune(tuneIndex, tuneAddOn);
        this.addOns.add(tuneAddOn);
    }

    public List<String> getAddOns() {
        return Collections.unmodifiableList(this.addOns);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator())
                .append("Add-ons: ");

        if (this.getAddOns().size() == 0) {
            sb.append("None");
        } else {
            sb.append(String.join(", ", this.getAddOns()));
        }

        return sb.toString();
    }
}
