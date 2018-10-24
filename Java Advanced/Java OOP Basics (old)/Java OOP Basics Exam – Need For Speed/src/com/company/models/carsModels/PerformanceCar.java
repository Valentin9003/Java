package com.company.models.carsModels;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {

    private List<String> addOns;

    public PerformanceCar(String brand,
                          String model,
                          int yearOfProduction,
                          int horsepower,
                          int acceleration,
                          int suspension,
                          int durability) {

        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.calculateHorsepower();
        this.calculateSuspension();
        this.addOns = new ArrayList<>();
    }

    @Override
    public void tune(int tuneIndex, String tuneAddOn) {
        super.setHorsepower(super.getHorsepower() + tuneIndex);
        super.setSuspension(super.getSuspension() + (tuneIndex / 2));
        this.setAddOns(tuneAddOn);
    }

    private void setAddOns(String addOnsName) {
        addOns.add(addOnsName);
    }

    private void calculateSuspension() {
    //Decreases its given suspension by 25%.
        super.setSuspension(super.getSuspension() - (super.getSuspension() * 25) / 100);

    }

    private void calculateHorsepower() {
     //Increases its given horsepower by 50%.
        super.setHorsepower(super.getHorsepower() + (super.getHorsepower() * 50) / 100);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s %d%n", this.getBrand(), this.getModel(), this.getYearOfProduction()))
                .append(String.format("%d HP, 100 m/h in %d s%n", this.getHorsepower(), this.getAcceleration()))
                .append(String.format("%d Suspension force, %d Durability", this.getSuspension(), this.getDurability()));

        if (addOns.size() == 0) {
            sb.append(String.format("%nAdd-ons: None"));
        } else {
            String addOnsStr = String.join(", ", addOns);
            sb.append(String.format("%nAdd-ons: %s", addOnsStr));
        }

        return sb.toString();
    }
}
