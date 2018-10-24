package p03_wildFarm.models.animalModels;

import p03_wildFarm.models.animalModels.interfaces.IAnimal;
import p03_wildFarm.models.foodModels.Food;
import p03_wildFarm.util.ConfigExMessage;

public abstract class Animal implements IAnimal {

    private static final int DEFAULT_EATEN_FOOD = 0;

    private String name;
    private double weight;
    private int foodEaten;

    public Animal(String name, double weight) {
        this.setName(name);
        this.setWeight(weight);
        this.foodEaten = DEFAULT_EATEN_FOOD;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ConfigExMessage.EMPTY_ANIMAL_NAME_EX_MESSAGE);
        }
        this.name = name;
    }

    private void setWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException(ConfigExMessage.NEGATIVE_WEIGHT_EX_MESSAGE);
        }
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getFoodEaten() {
        return this.foodEaten;
    }

    public abstract String makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }
}
