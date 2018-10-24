package p05_pizzaCalories.models;

import p05_pizzaCalories.models.util.ConfigModifiers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza {

    private static final int MAX_PIZZA_NAME_LENGTH = 15;
    private static final int MIN_NUMBER_OF_TOPPINGS = 0;
    private static final int MAX_NUMBER_OF_TOPPINGS = 10;
    private static final String PIZZA_NAME_EXCEPTION_MESSAGE = "Pizza name should be between 1 and 15 symbols.";
    private static final String TOPPINGS_OUT_OF_RANGE_EXCEPTION_MESSAGE = "Number of toppings should be in range [0..10].";

    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setNumberOfToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.length() > MAX_PIZZA_NAME_LENGTH) {
            throw new IllegalArgumentException(PIZZA_NAME_EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public List<Topping> getToppings() {
        return Collections.unmodifiableList(this.toppings);
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    private int getNumberOfToppings() {
        return numberOfToppings;
    }

    private void setNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings < MIN_NUMBER_OF_TOPPINGS || numberOfToppings > MAX_NUMBER_OF_TOPPINGS) {
            throw new IllegalArgumentException(TOPPINGS_OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
        this.numberOfToppings = numberOfToppings;
    }

    public double getPizzaCalories() {
        return calculateCalories();
    }

    private double calculateCalories() {
        return this.getDough().getCalories() + this.getToppings().stream().mapToDouble(Topping::getCalories).sum();
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.getName(), this.getPizzaCalories());
    }
}
