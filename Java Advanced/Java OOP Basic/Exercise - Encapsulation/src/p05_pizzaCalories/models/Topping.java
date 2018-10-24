package p05_pizzaCalories.models;

import p05_pizzaCalories.models.util.ConfigModifiers;

import java.util.List;

public class Topping {

    private static final List<String> TOPPINGS_TYPES = List.of("Meat", "Veggies", "Cheese", "Sauce");
    private static final String INVALID_TOPPING_TYPE_EXCEPTION_MESSAGE = "Cannot place %s on top of your pizza.";
    private static final int MIN_TOPPING_WEIGHT = 1;
    private static final int MAX_TOPPING_WEIGHT = 50;
    private static final String INVALID_TOPPING_WEIGHT_EXCEPTION_MESSAGE = "%s weight should be in the range [1..50].";
    private static final int BASE_CALORIES_PER_GRAM = 2;

    private String toppingType;
    private int weightInGrams;

    public Topping(String toppingType, int weightInGrams) {
        this.setToppingType(toppingType);
        this.setWeightInGrams(weightInGrams);
    }

    public String getToppingType() {
        return this.toppingType;
    }

    private void setToppingType(String toppingType) {
        if (!TOPPINGS_TYPES.contains(toppingType)) {
            throw new IllegalArgumentException(String.format(INVALID_TOPPING_TYPE_EXCEPTION_MESSAGE, toppingType));
        }
        this.toppingType = toppingType;
    }

    public int getWeightInGrams() {
        return this.weightInGrams;
    }

    private void setWeightInGrams(int weightInGrams) {
        if (weightInGrams < MIN_TOPPING_WEIGHT || weightInGrams > MAX_TOPPING_WEIGHT) {
            throw new IllegalArgumentException(String.format(INVALID_TOPPING_WEIGHT_EXCEPTION_MESSAGE, this.getToppingType()));
        }
        this.weightInGrams = weightInGrams;
    }

    public double getCalories() {
        return this.calculateToppingTotalCalories();
    }

    private double calculateToppingTotalCalories() {
        double toppingModifierCl = ConfigModifiers.TOPPINGS_MODIFIERS.get(this.getToppingType());

        return this.getWeightInGrams() * BASE_CALORIES_PER_GRAM * toppingModifierCl;
    }
}
