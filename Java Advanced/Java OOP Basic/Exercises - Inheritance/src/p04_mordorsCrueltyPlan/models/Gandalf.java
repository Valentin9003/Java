package p04_mordorsCrueltyPlan.models;

import p04_mordorsCrueltyPlan.models.util.ConfigFood;

import java.util.Arrays;

public class Gandalf {

    private static final int DEFAULT = 0;

    private Happiness happiness;

    public Gandalf() {
        this.happiness = new Happiness(DEFAULT);
    }

    public void eat(String[] foods){
        Arrays.stream(foods)
                .forEach(food -> this.happiness.addHappiness(getHappinesPT(food)));
    }

    private int getHappinesPT(String food) {
        switch (food.toLowerCase()) {
            case ConfigFood.CRAM:
                return ConfigFood.CREAM_POINTS;
            case ConfigFood.LEMBAS:
                return ConfigFood.LEMBAS_POINTS;
            case ConfigFood.APPLE:
                return ConfigFood.APPLE_POINTS;
            case ConfigFood.MELON:
                return ConfigFood.MELON_POINTS;
            case ConfigFood.HONEY_CAKE:
                return ConfigFood.HONEY_CAKE_POINTS;
            case ConfigFood.MUSHROOMS:
                return ConfigFood.MUSHROOMS_POINTS;
            default:
                return ConfigFood.EVERYTHING_ELSE_POINTS;
        }
    }

    @Override
    public String toString() {
        return String.format("%d%n%s",
                this.happiness.getHappiness(),
                this.happiness.getMood());
    }
}
