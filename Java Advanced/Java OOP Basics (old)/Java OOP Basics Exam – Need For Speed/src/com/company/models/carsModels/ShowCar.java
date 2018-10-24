package com.company.models.carsModels;

public class ShowCar extends Car {

    private static final int DEFAULT_STARS = 0;

    private int stars;

    public ShowCar(String brand,
                   String model,
                   int yearOfProduction,
                   int horsepower,
                   int acceleration,
                   int suspension,
                   int durability) {

        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = DEFAULT_STARS;
    }

    private void setStars(int tuneIndex) {
        this.stars += tuneIndex;
    }

    @Override
    public void tune(int tuneIndex, String tuneAddOn) {
        super.setHorsepower(super.getHorsepower() + tuneIndex);
        super.setSuspension(super.getSuspension() + (tuneIndex / 2));
        this.setStars(tuneIndex);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s %d%n", this.getBrand(), this.getModel(), this.getYearOfProduction()))
                .append(String.format("%d HP, 100 m/h in %d s%n", this.getHorsepower(), this.getAcceleration()))
                .append(String.format("%d Suspension force, %d Durability%n", this.getSuspension(), this.getDurability()))
                .append(String.format("%d *", this.stars));

        return sb.toString();
    }
}
