package com.company.problem05PizzaCalories.models;

public class Topping {
    private static final double MEAT_MODIFIER = 1.2;
    private static final double VEGGIES_MODIFIER = 0.8;
    private static final double CHEESE_MODIFIER = 1.1;
    private static final double SAUCE_MODIFIER = 0.9;

    private String type;
    private int weight;

    public Topping(String type, int weight) {
        this.setType(type);
        this.setWeight(weight);
    }

    private void setType(String type) {
        if (!type.equalsIgnoreCase("meat")
                && !type.equalsIgnoreCase("veggies")
                && !type.equalsIgnoreCase("cheese")
                && !type.equalsIgnoreCase("sauce")) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", type));
        }
        this.type = type;
    }

    private void setWeight(int weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", type));
        }
        this.weight = weight;
    }

    private double getModifier(String type) {
        switch (type.toLowerCase()) {
            case "meat":
                return Topping.MEAT_MODIFIER;

            case "veggies":
                return Topping.VEGGIES_MODIFIER;

            case "cheese":
                return Topping.CHEESE_MODIFIER;

            case "sauce":
                return Topping.SAUCE_MODIFIER;

                default:
                    return 1.0;
        }
    }

    public double getCalories() {
        return 2 * this.weight * this.getModifier(this.type);
    }
}
